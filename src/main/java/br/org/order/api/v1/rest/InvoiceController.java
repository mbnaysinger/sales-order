package br.org.order.api.v1.rest;

import br.org.fiergs.common.model.exception.AccessForbiddenException;
import br.org.order.domain.service.BlobStorageService;
import com.azure.storage.blob.models.BlobItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.ByteBuffer;

@RestController("InvoiceControllerV1")
@RequestMapping("/invoice")
public class InvoiceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceController.class);
    private static final String AUTHORIZATION_ERROR = "Acesso negado";

    private String apiKey;
    private final BlobStorageService blobService;

    public InvoiceController(@Value("${app.bank-slip-api-key}") String apiKey, BlobStorageService blobService) {
        this.apiKey = apiKey;
        this.blobService = blobService;
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
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

    @GetMapping("/list")
    public Mono<ResponseEntity<Flux<String>>> listInvoices(@RequestHeader("X-API-Key") String apiKeyParam) {
        LOGGER.info("Iniciando listagem de blobs para o container");

        return Mono.justOrEmpty(apiKey.equals(apiKeyParam) ? apiKey : null)
                .switchIfEmpty(Mono.error(new AccessForbiddenException(AUTHORIZATION_ERROR)))
                .flatMap(validApiKey -> Mono.just(ResponseEntity.ok(
                        blobService.listInvoices()
                                .map(BlobItem::getName)
                                .doOnComplete(() -> LOGGER.info("Listagem de invoices concluída"))
                                .doOnError(error -> LOGGER.error(error.getMessage()))
                )));
    }

    @GetMapping("/download/{filename}")
    public Mono<ResponseEntity<InputStreamResource>> downloadImputStream(
            @PathVariable String filename,
            @RequestHeader("X-API-Key") String apiKeyParam) {

        LOGGER.info("Iniciando download do arquivo: {}", filename);

        return Mono.justOrEmpty(apiKey.equals(apiKeyParam) ? apiKey : null)
                .switchIfEmpty(Mono.error(new AccessForbiddenException(AUTHORIZATION_ERROR)))
                .flatMap(validApiKey -> blobService.downloadInvoice(filename)
                        .map(inputStream -> ResponseEntity.ok()
                                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                                .body(new InputStreamResource(inputStream)))
                        .doOnSuccess(result -> LOGGER.info("Download do arquivo {} concluído com sucesso", filename))
                        .doOnError(error -> LOGGER.error("Erro ao baixar arquivo {}: {}", filename, error.getMessage())));
    }

    private DataBuffer convertToDataBuffer(ByteBuffer byteBuffer) {
        byte[] bytes = new byte[byteBuffer.remaining()];
        byteBuffer.get(bytes);
        return new DefaultDataBufferFactory().wrap(bytes);
    }

    @GetMapping("/download-resource/{filename}")
    public Mono<ResponseEntity<Resource>> downloadResource(
            @PathVariable String filename,
            @RequestHeader("X-API-Key") String apiKeyParam) {

        LOGGER.info("Iniciando download do arquivo: {}", filename);

        return Mono.justOrEmpty(apiKey.equals(apiKeyParam) ? apiKey : null)
                .switchIfEmpty(Mono.error(new AccessForbiddenException(AUTHORIZATION_ERROR)))
                .flatMap(validApiKey -> blobService.downloadInvoice(filename)
                        .map(inputStream -> ResponseEntity.ok()
                                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                                .body((Resource) new InputStreamResource(inputStream)))
                        .doOnSuccess(result -> LOGGER.info("Download do arquivo {} concluído com sucesso", filename))
                        .doOnError(error -> LOGGER.error("Erro ao baixar arquivo {}: {}", filename, error.getMessage())));
    }
}