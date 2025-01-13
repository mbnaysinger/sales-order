package br.org.order.domain.service;

import br.org.order.api.v1.dto.order.OrderDTO;
import br.org.order.api.v1.dto.order.OrderResponseDTO;
import br.org.order.config.OrderClient;
import br.org.order.domain.model.BillingData;
import br.org.order.domain.model.OrderProcedureReturn;
import br.org.order.domain.port.OrderProcedurePort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    private final OrderClient orderClient;
    private final OrderProcedurePort opp;

    public OrderService(OrderClient orderClient, OrderProcedurePort opp) {
        this.orderClient = orderClient;
        this.opp = opp;
    }

    public Mono<OrderResponseDTO> generOrder(OrderDTO orderDto, String token, String origin) throws Exception {
        return orderClient.callSoapClient(orderDto, token, origin);
    }

    public Mono<OrderProcedureReturn> insereTitulo(BillingData bd) {
        return opp.insereTitulo(bd);
    }
}