package br.com.xmob.orders.productphoto.infra;

import br.com.xmob.orders.config.storage.StorageS3Properties;
import br.com.xmob.orders.productphoto.domain.NewPhoto;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
@Slf4j
@RequiredArgsConstructor
public class PhotoStorageS3 implements PhotoStorage {

    private final AmazonS3 amazonS3;
    private final StorageS3Properties storageProperties;

    @Override
    public URL store(NewPhoto photo) {
        log.info("[start] PhotoStorageS3 - store");
        try {
            String filepath = getFilePath(photo.getFilename());

            var objectMetaData = new ObjectMetadata();
            objectMetaData.setContentType(photo.getContentType());

            var putObjectRequest = new PutObjectRequest(
                    storageProperties.getBucket(),
                    filepath,
                    photo.getInputStream(),
                    objectMetaData)
                    .withCannedAcl(CannedAccessControlList.PublicRead);

            amazonS3.putObject(putObjectRequest);

            log.info("[finish] PhotoStorageS3 - store");
            return amazonS3.getUrl(storageProperties.getBucket(), filepath);
        } catch (Exception ex) {
            throw new RuntimeException("Error ao armazenar foto");
        }
    }

        private String getFilePath(String filename){
            return String.format("%s/%s", storageProperties.getDirectoryPhotos(), filename);
        }
}
