package br.org.order.infrastructure.adapter;

import br.org.order.domain.port.BlobStoragePort;
import com.azure.core.util.BinaryData;
import com.azure.storage.blob.BlobAsyncClient;
import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.BlobServiceAsyncClient;
import com.azure.storage.blob.models.BlobItem;
import com.azure.storage.blob.models.BlobStorageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.ByteBuffer;

@Component
public class AzureBlobStorageAdapter implements BlobStoragePort {

    private final BlobServiceAsyncClient blobServiceAsyncClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(AzureBlobStorageAdapter.class);

    @Autowired
    public AzureBlobStorageAdapter(BlobServiceAsyncClient blobServiceAsyncClient) {
        this.blobServiceAsyncClient = blobServiceAsyncClient;
    }

    private BlobContainerAsyncClient getContainerClient(String containerName) {
        return blobServiceAsyncClient.getBlobContainerAsyncClient(containerName);
    }

    @Override
    public Mono<String> uploadFile(String fileName, byte[] content, String containerName) {
        BlobAsyncClient blobAsyncClient = getContainerClient(containerName).getBlobAsyncClient(fileName);

        return blobAsyncClient.upload(BinaryData.fromBytes(content), true)
                .thenReturn("Arquivo " + fileName + " salvo com sucesso");
    }

    @Override
    public Mono<ByteBuffer> downloadFile(String containerName, String blobName) {
        LOGGER.info("Iniciando download do blob: {} do container: {}", blobName, containerName);
        BlobAsyncClient blobAsyncClient = getContainerClient(containerName).getBlobAsyncClient(blobName);

        return Mono.fromCallable(() -> {
                    LOGGER.info("Verificando existência do blob: {}", blobName);
                    return blobAsyncClient.exists().block();
                })
                .flatMap(exists -> {
                    if (Boolean.TRUE.equals(exists)) {
                        LOGGER.info("Blob {} encontrado. Iniciando download.", blobName);
                        return blobAsyncClient.downloadContent()
                                .map(binaryData -> {
                                    ByteBuffer byteBuffer = binaryData.toByteBuffer();
                                    LOGGER.info("Download concluído para {}. Tamanho: {} bytes", blobName, byteBuffer.remaining());
                                    return byteBuffer;
                                });
                    } else {
                        LOGGER.error("Blob {} não encontrado no container {}", blobName, containerName);
                        return Mono.error(new RuntimeException("Arquivo não encontrado: " + blobName));
                    }
                })
                .doOnError(error -> LOGGER.error("Erro ao baixar blob {}: {}", blobName, error.getMessage(), error));
    }

    @Override
    public Mono<Void> deleteFile(String containerName, String blobName) {
        BlobAsyncClient blobAsyncClient = getContainerClient(containerName).getBlobAsyncClient(blobName);

        return blobAsyncClient.delete()
                .onErrorResume(BlobStorageException.class, e -> {
                    if (e.getStatusCode() == 404) {
                        return Mono.empty();
                    }
                    return Mono.error(e);
                });
    }

    @Override
    public Flux<BlobItem> listBlobs(String containerName) {
        BlobContainerAsyncClient containerClient = getContainerClient(containerName);

        return containerClient.listBlobs()
                .onErrorResume(BlobStorageException.class, e -> {
                    if (e.getStatusCode() == 404) {
                        return Flux.error(new RuntimeException("Container : " + containerName + " não encontrado"));
                    }
                    return Flux.error(e);
                });
    }

}
