package br.org.order.domain.port;

import reactor.core.publisher.Mono;

public interface ClientSoapPort {

    Mono<Boolean> debtorConsult(String taxpayerId);
}
