package br.org.order.api.v1.rest;

import br.org.fiergs.common.model.exception.AccessForbiddenException;
import br.org.order.api.v1.converter.BillingDataConverter;
import br.org.order.api.v1.dto.order.BillingDataDTO;
import br.org.order.domain.model.BillingData;
import br.org.order.domain.model.OrderProcedureReturn;
import br.org.order.domain.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;
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

    public SalesOrderController(@Value("${app.bank-slip-api-key}") String apiKey,
                                OrderService orderService) {
        this.apiKey = apiKey;
        this.orderService = orderService;
        this.billingDataConverter = new BillingDataConverter();
    }

    @GetMapping("/list")
    public Mono<List<Map<String, String>>> getMockBankSlips(@RequestParam ("just_open") Optional<Boolean> justOpen) {
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

    @PostMapping("/invoice")
    public Mono<String> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("id") String id,
            @RequestHeader("X-API-Key") String apiKeyParam) {

        return Mono.justOrEmpty(apiKey.equals(apiKeyParam) ? apiKey : null)
                .switchIfEmpty(Mono.error(new AccessForbiddenException("Autorização inválida")))
                .flatMap(validApiKey -> {
                    try {
                        // Ler o arquivo recebido
                        byte[] fileBytes = file.getBytes();

                        LOGGER.info("Arquivo recebido: " + file.getOriginalFilename() + " com ID: " + id);

                        // Aqui, você pode proceder com o processamento que necessitar, como salvar o arquivo

                        return Mono.just("Arquivo recebido com sucesso!");
                    } catch (IOException e) {
                        LOGGER.error("Erro ao processar o arquivo: {}", e.getMessage());
                        return Mono.error(new IllegalArgumentException("Erro ao processar arquivo"));
                    }
                });
    }

    @PostMapping("/generate")
    public Mono<ResponseEntity<OrderProcedureReturn>> insereTitulo(@RequestBody BillingDataDTO billingDataDTO) {
        BillingData billingData = billingDataConverter.convertToEntity(billingDataDTO);

        return orderService.insereTitulo(billingData)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}