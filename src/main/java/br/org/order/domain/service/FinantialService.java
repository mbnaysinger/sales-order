package br.org.order.domain.service;

import br.org.fiergs.person.model.TaxpayerId;
import br.org.order.domain.port.ClientSoapPort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FinantialService {

    private final ClientSoapPort clientSoapPort;

    public FinantialService(ClientSoapPort clientSoapPort) {
        this.clientSoapPort = clientSoapPort;
    }

    public Mono<Boolean> debtorConsult(String taxpayerId) {
        TaxpayerId tpi = TaxpayerId.of(taxpayerId);

        return clientSoapPort.debtorConsult(tpi.getNumber());
    }
}