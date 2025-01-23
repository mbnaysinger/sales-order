package br.org.order.infrastructure.adapter;

import br.org.order.domain.port.ClientSoapPort;
import br.org.order.infrastructure.soap.DebtorWsClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DebtorSoapResponseAdapter implements ClientSoapPort {

    private final DebtorWsClient debtorWsClient;

    public DebtorSoapResponseAdapter(DebtorWsClient debtorWsClient) {
        this.debtorWsClient = debtorWsClient;
    }

    @Override
    public Mono<Boolean> debtorConsult(String xmlResponse) {
        return debtorWsClient.debtorConsult(xmlResponse);
    }
}
