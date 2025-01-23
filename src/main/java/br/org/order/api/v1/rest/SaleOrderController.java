package br.org.order.api.v1.rest;

import br.org.fiergs.common.model.exception.AccessForbiddenException;
import br.org.order.api.v1.converter.BillingDataConverter;
import br.org.order.api.v1.converter.OrderProcReturnConverter;
import br.org.order.domain.service.OrderService;
import br.org.order.domain.service.FinantialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController("SaleOrderControllerV1")
@RequestMapping("/v1/order")
public class SaleOrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SaleOrderController.class);
    private static final String AUTHORIZATION_ERROR = "Acesso negado";

    private String apiKey;
    private final OrderService orderService;
    private final BillingDataConverter billingDataConverter;
    private final OrderProcReturnConverter oprConverter;
    private final FinantialService ss;


    public SaleOrderController(@Value("${app.sale-order-key}") String apiKey,
                               OrderService orderService, BillingDataConverter billingDataConverter,
                               OrderProcReturnConverter oprConverter, FinantialService ss) {
        this.apiKey = apiKey;
        this.orderService = orderService;
        this.billingDataConverter = billingDataConverter;
        this.oprConverter = oprConverter;
        this.ss = ss;
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

    @GetMapping("/debtor/{taxpayerid}")
    public Mono<Boolean> listInvoices(@RequestHeader("X-API-Key") String apiKeyParam,
                                      @RequestParam String taxpayerid) {
        return Mono.defer(() -> {
            if (apiKeyParam.equals(apiKey)) {
                return ss.debtorConsult(taxpayerid);
            } else {
                return Mono.error(new AccessForbiddenException(AUTHORIZATION_ERROR));
            }
        });
    }
}