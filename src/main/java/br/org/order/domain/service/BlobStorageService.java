package br.org.order.domain.service;

import java.io.InputStream;
import java.nio.ByteBuffer;

import br.org.order.domain.port.BlobStoragePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.azure.storage.blob.models.BlobItem;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BlobStorageService {

    private final BlobStoragePort blobStoragePort;
    private final String contInvoice;
    private final String contBankSlip;

    @Autowired
    public BlobStorageService(BlobStoragePort blobStoragePort,
                                  @Value("${azure.storage.container-invoice}") String contInvoice,
                                  @Value("${azure.storage.container-bank-slip}") String contBankSlip) {
        this.blobStoragePort = blobStoragePort;
        this.contInvoice = contInvoice;
        this.contBankSlip = contBankSlip;
    }

    public Mono<String> uploadInvoice(String fileName, byte[] content) {
        return blobStoragePort.uploadFile(fileName, content, contInvoice);
    }

    public Mono<String> uploadBankSlip(String fileName, byte[] content) {
        return blobStoragePort.uploadFile(fileName, content, contBankSlip);
    }

    public Mono<InputStream> downloadInvoice(String blobName) {
        return blobStoragePort.downloadFile(blobName, contInvoice);
    }

    public Mono<ByteBuffer> downloadInvoiceByte(String blobName) {
        return blobStoragePort.downloadFileByte(blobName, contInvoice);
    }

    public Mono<InputStream> downloadBankSlip(String blobName) {
        return blobStoragePort.downloadFile(blobName, contBankSlip);
    }

    public Flux<BlobItem> listInvoices() {
        return blobStoragePort.listBlobs(contInvoice);
    }

    public Flux<BlobItem> listBankSlips() {
        return blobStoragePort.listBlobs(contBankSlip);
    }
}