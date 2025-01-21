package br.org.order.config;

import com.azure.storage.blob.BlobServiceAsyncClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.storage.blob.BlobServiceClientBuilder;

@Configuration
public class BlobStorageConfig {

    @Value("${azure.storage.connection-string}")
    private String connectionString;

    @Bean
    public BlobServiceAsyncClient blobServiceAsyncClient() {
        return new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .buildAsyncClient();
    }
}
