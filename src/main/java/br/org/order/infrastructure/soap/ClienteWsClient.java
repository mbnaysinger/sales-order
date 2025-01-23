package br.org.order.infrastructure.soap;

import br.org.order.infrastructure.soap.dto.ClienteSoapResponseDTO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
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
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.UUID;

@Component
public class ClienteWsClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteWsClient.class);

    private final WebClient webClient;
    private final Configuration freemarkerConfiguration;

    public ClienteWsClient(WebClient.Builder webClientBuilder,
                           Configuration freemarkerConfiguration,
                           @Value("${client-ws-endpoint}") String slipEndpoint) throws SSLException {
        this.freemarkerConfiguration = freemarkerConfiguration;

        var sslContext = SslContextBuilder
                .forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();

        var httpClient = HttpClient.create()
                .secure(it -> it.sslContext(sslContext));

        this.webClient = webClientBuilder
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(slipEndpoint)
                .build();
    }

    public Mono<ClienteSoapResponseDTO> callSoapService(String username, String password, String cpfCnpj) {
        Mono<String> xmlRequestMono = Mono.fromCallable(() -> createRequest(username, password, cpfCnpj))
                .doOnSuccess(str -> System.out.println("### SOAP Request:\n" + str));

        return webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_XML_VALUE)
                .body(xmlRequestMono, String.class)
                .retrieve()
                .onStatus(HttpStatus::isError, this::handleError)
                .bodyToMono(ClienteSoapResponseDTO.class)
                .doOnSuccess(response -> System.out.println("### SOAP Response: " + response));
    }

    private String createRequest(String username, String password, String cpfCnpj) throws IOException, TemplateException {
        var nonce = Base64.getEncoder().encodeToString((UUID.randomUUID().toString()).getBytes(StandardCharsets.UTF_8));
        var created = Instant.now().toString();

        var dataModel = new HashMap<String, Object>();
        dataModel.put("username", username);
        dataModel.put("password", password);
        dataModel.put("cpfCnpj", cpfCnpj);
        dataModel.put("nonce", nonce);
        dataModel.put("created", created);
        dataModel.put("tokenId", UUID.randomUUID().toString());

        Template template = freemarkerConfiguration.getTemplate("cliente-request-template.ftl");
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, dataModel);
    }

    private Mono<Throwable> handleError(ClientResponse response) {
        return response.bodyToMono(String.class)
                .flatMap(body -> Mono.error(new WebClientResponseException("Could not invoke SOAP service",
                        response.rawStatusCode(), response.statusCode().toString(), response.headers().asHttpHeaders(), null, null)));
    }
}
