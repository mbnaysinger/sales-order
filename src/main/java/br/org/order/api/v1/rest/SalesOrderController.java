package br.org.order.api.v1.rest;

import br.org.fiergs.common.model.exception.AccessForbiddenException;
import br.org.order.api.v1.converter.BillingDataConverter;
import br.org.order.api.v1.dto.order.BillingDataDTO;
import br.org.order.domain.model.BillingData;
import br.org.order.domain.model.OrderProcedureReturn;
import br.org.order.domain.service.BlobStorageService;
import br.org.order.domain.service.OrderService;
import com.azure.storage.blob.models.BlobItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@RestController("SalesOrderControllerV1")
@RequestMapping("/order")
public class SalesOrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SalesOrderController.class);
    private static final String AUTHORIZATION_ERROR = "Acesso negado";

    private String apiKey;
    private final OrderService orderService;
    private final BillingDataConverter billingDataConverter;
    private final BlobStorageService blobService;

    public SalesOrderController(@Value("${app.bank-slip-api-key}") String apiKey,
                                OrderService orderService, BlobStorageService blobService) {
        this.apiKey = apiKey;
        this.orderService = orderService;
        this.blobService = blobService;
        this.billingDataConverter = new BillingDataConverter();
    }

    @GetMapping("/list")
    public Mono<List<Map<String, String>>> getMockBankSlips(@RequestParam("just_open") Optional<Boolean> justOpen) {
        List<Map<String, String>> mockList = Arrays.asList(
                createMockRecord("1", "8232681942", "SOF", "Boleto DNS", "28000640190124160", "000043127/NFS", "F58773", "A"),
                createMockRecord("2", "8232664683", "CDE", "Boleto CDE", "28000640190124150", "000043128/NFS", "F58770", "A"),
                createMockRecord("3", "8232660986", "SOF", "Boleto DNS", "28000640190124140", "000043129/NFS", "F58768", "A"),
                createMockRecord("4", "8232576912", "CDE", "Boleto CDE", "28000640190124130", "000043130/NFS", "F58766", "A"),
                createMockRecord("5", "8232561927", "SOF", "Boleto DNS", "28000640190124120", "000043131/NFS", "F58741", "C"),
                createMockRecord("6", "8232551593", "CDE", "Boleto CDE", "28000640190124110", "000043132/NFS", "F58720", "C")
        );

        List<Map<String, String>> filteredList = mockList;

        // Se a flag estiver presente e for verdadeira, filtrar para apenas status "A"
        if (justOpen.isPresent() && justOpen.get()) {
            filteredList = mockList.stream()
                    .filter(order -> "A".equals(order.get("status")))
                    .collect(Collectors.toList());
        }

        return Mono.just(filteredList);
    }

    private Map<String, String> createMockRecord(String id, String correlationId, String sourceSystem,
                                                 String integrationMessage, String securitiesNumber, String rps, String salesOrderNumber, String status) {
        Map<String, String> record = new HashMap<>();
        record.put("id", id);
        record.put("correlationId", correlationId);
        record.put("sourceSystem", sourceSystem);
        record.put("integrationMessage", integrationMessage);
        record.put("securitiesNumber", securitiesNumber);
        record.put("rps", rps);
        record.put("salesOrderNumber", salesOrderNumber);
        record.put("status", status);
        return record;
    }

    @PostMapping("/generate")
    public Mono<ResponseEntity<OrderProcedureReturn>> billing(@Valid @RequestBody BillingDataDTO billingDataDTO) {
        BillingData billingData = billingDataConverter.convertToEntity(billingDataDTO);

        return orderService.insereTitulo(billingData)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

    @PostMapping(value = "/invoice", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<String> uploadInvoice(
            @RequestPart("file") Mono<FilePart> filePart,
            @RequestPart("billingId") String billingId,
            @RequestHeader("X-API-Key") String apiKeyParam) {

        LOGGER.info("Recebendo requisição para billingId: {}", billingId);

        return Mono.justOrEmpty(apiKey.equals(apiKeyParam) ? apiKey : null)
                .switchIfEmpty(Mono.error(new AccessForbiddenException(AUTHORIZATION_ERROR)))
                .flatMap(validApiKey -> filePart
                        .flatMap(part -> {
                            String originalFilename = part.filename();
                            String fileName = generateFileName(billingId, originalFilename);
                            LOGGER.info("Processando arquivo: {} com ID: {}", fileName, billingId);

                            return part.content()
                                    .reduce(DataBuffer::write)
                                    .map(buffer -> {
                                        byte[] bytes = new byte[buffer.readableByteCount()];
                                        buffer.read(bytes);
                                        DataBufferUtils.release(buffer);
                                        return bytes;
                                    })
                                    .flatMap(fileBytes -> blobService.uploadInvoice(fileName, fileBytes)
                                            .doOnSuccess(result -> LOGGER.info("Arquivo enviado com sucesso: {}", fileName))
                                            .doOnError(error -> LOGGER.error("Erro ao enviar arquivo: {}", error.getMessage()))
                                    );
                        })
                )
                .onErrorResume(IOException.class, e -> {
                    LOGGER.error("Erro ao ler o arquivo: {}", e.getMessage());
                    return Mono.error(new IllegalArgumentException("Erro ao processar arquivo"));
                });
    }

    private String generateFileName(String id, String originalFilename) {
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        return "invoice_" + id + "_" + System.currentTimeMillis() + extension;
    }

    @GetMapping("/document/{fileName}")
    public Mono<ResponseEntity<DataBuffer>> downloadDocument(@PathVariable String fileName) {
        String decodedFileName = URLDecoder.decode(fileName, StandardCharsets.UTF_8);
        LOGGER.info("Iniciando download do arquivo: {}", decodedFileName);

        return blobService.downloadInvoice(decodedFileName)
                .doOnSubscribe(subscription -> LOGGER.info("Iniciando download do blob: {}", decodedFileName))
                .doOnNext(byteBuffer -> LOGGER.info("ByteBuffer recebido para {}, tamanho: {}", decodedFileName, byteBuffer.remaining()))
                .map(this::convertToDataBuffer)
                .map(dataBuffer -> {
                    LOGGER.info("DataBuffer criado para {}, tamanho: {}", decodedFileName, dataBuffer.readableByteCount());
                    return ResponseEntity.ok()
                            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + decodedFileName + "\"")
                            .contentType(MediaType.APPLICATION_OCTET_STREAM)
                            .body(dataBuffer);
                })
                .doOnSuccess(result -> LOGGER.info("Download do arquivo {} concluído com sucesso", decodedFileName))
                .doOnError(error -> LOGGER.error("Erro ao baixar arquivo {}: {}", decodedFileName, error.getMessage(), error));
    }

    private DataBuffer convertToDataBuffer(ByteBuffer byteBuffer) {
        byte[] bytes = new byte[byteBuffer.remaining()];
        byteBuffer.get(bytes);
        return new DefaultDataBufferFactory().wrap(bytes);
    }

    @GetMapping("/invoices")
    public Flux<String> listInvoices() {
        LOGGER.info("Iniciando listagem de blobs para o container");

        return blobService.listInvoices()
                .map(BlobItem::getName)
                .doOnComplete(() -> LOGGER.info("Listagem de invoices concluída"))
                .doOnError(error -> LOGGER.error(error.getMessage()));
    }
}