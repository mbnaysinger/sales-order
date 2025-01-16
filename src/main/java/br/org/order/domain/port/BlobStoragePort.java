package br.org.order.domain.port;

import com.azure.storage.blob.models.BlobItem;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.InputStream;
import java.nio.ByteBuffer;

public interface BlobStoragePort {
    Mono<String> uploadFile(String fileName, byte[] content, String containerName);
    Mono<InputStream> downloadFile(String blobName, String containerName);
    Mono<ByteBuffer> downloadFileByte(String blobName, String containerName);
    Mono<Void> deleteFile(String containerName, String blobName);
    Flux<BlobItem> listBlobs(String containerName);
}
