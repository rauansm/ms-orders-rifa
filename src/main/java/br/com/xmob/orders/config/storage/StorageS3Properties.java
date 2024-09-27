package br.com.xmob.orders.config.storage;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("storage.s3")
public class StorageS3Properties {
        private String idKeyAccess;
        private String keyAccessSecret;
        private String bucket;
        private String region;
        private String directoryPhotos;
}
