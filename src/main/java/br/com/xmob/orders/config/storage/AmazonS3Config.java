package br.com.xmob.orders.config.storage;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AmazonS3Config {

    private final StorageS3Properties storageProperties;

    @Bean
        public AmazonS3 amazonS3() {
        var credentials = new BasicAWSCredentials(storageProperties.getIdKeyAccess(),storageProperties.getKeyAccessSecret());
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(storageProperties.getRegion())
                .build();
    }

}
