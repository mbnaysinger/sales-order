package br.org.order.infrastructure.soap;

import freemarker.template.Configuration;
import freemarker.template.Template;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
public class DebtorWsClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(DebtorWsClient.class);

    private final WebClient webClient;
    private final Configuration freemarkerConfiguration;

    public DebtorWsClient(
            WebClient.Builder webClientBuilder,
            Configuration freemarkerConfiguration,
            @Value("${client-ws-endpoint}") String endpoint
    ) throws SSLException {
        this.freemarkerConfiguration = freemarkerConfiguration;

        var sslContext = SslContextBuilder
                .forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();

        var httpClient = HttpClient.create()
                .secure(it -> it.sslContext(sslContext));

        this.webClient = webClientBuilder
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(endpoint)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_XML_VALUE)
                .build();
    }

    public Mono<Boolean> debtorConsult(String taxpayerId) {
        Mono<String> soapRequestMono = createSoapRequest(taxpayerId);

        return webClient.post()
                .body(soapRequestMono, String.class)
                .retrieve()
                .onStatus(HttpStatus::isError, this::handleError)
                .bodyToMono(String.class)
                .publishOn(Schedulers.boundedElastic())
                .map(xmlResponse -> {
                    boolean isDebtor = xmlResponse.contains("<return>Sim</return>");
                    LOGGER.debug("### SOAP Response: {}", isDebtor);
                    return isDebtor;
                });
    }

    private Mono<String> createSoapRequest(String taxpayerId) {
        return Mono.fromCallable(() -> {

            Map<String, Object> model = new HashMap<>();
            model.put("taxpayerId", taxpayerId);

            Template template = freemarkerConfiguration.getTemplate("debtor-request-template.ftl");

            StringWriter writer = new StringWriter();
            template.process(model, writer);

            return writer.toString();
        });
    }

    private Mono<Throwable> handleError(ClientResponse response) {
        return response.bodyToMono(String.class)
                .flatMap(body -> Mono.error(new WebClientResponseException(
                        "Erro na chamada SOAP",
                        response.rawStatusCode(),
                        response.statusCode().toString(),
                        response.headers().asHttpHeaders(),
                        body.getBytes(),
                        StandardCharsets.UTF_8
                )));
    }
}
