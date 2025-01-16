package br.org.order.domain.port;

import com.azure.storage.blob.models.BlobItem;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.ByteBuffer;

public interface BlobStoragePort {
    Mono<String> uploadFile(String fileName, byte[] content, String containerName);
    Mono<ByteBuffer> downloadFile(String containerName, String blobName);
    Mono<Void> deleteFile(String containerName, String blobName);
    Flux<BlobItem> listBlobs(String containerName);
}
