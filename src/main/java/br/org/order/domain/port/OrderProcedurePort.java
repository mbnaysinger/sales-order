package br.org.order.domain.port;

import br.org.order.domain.model.BillingData;
import br.org.order.domain.model.OrderProcedureReturn;
import reactor.core.publisher.Mono;

public interface OrderProcedurePort {
    Mono<OrderProcedureReturn> insereTitulo(BillingData bd);
}
