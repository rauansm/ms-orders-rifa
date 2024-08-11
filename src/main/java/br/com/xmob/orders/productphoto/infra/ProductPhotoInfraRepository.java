package br.com.xmob.orders.productphoto.infra;

import br.com.xmob.orders.productphoto.domain.ProductPhoto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@Slf4j
@RequiredArgsConstructor
public class ProductPhotoInfraRepository implements ProductPhotoRepository {

    private final ProductPhotoSpringDataMongo photoSpringDataMongo;

    @Override
    public ProductPhoto saveProductPhoto(ProductPhoto productPhoto) {
        log.info("[start] ProductPhotoInfraRepository - saveProductPhoto");
        ProductPhoto photo = photoSpringDataMongo.save(productPhoto);
        log.info("[finish] ProductPhotoInfraRepository - saveProductPhoto");
        return photo;
    }

    @Override
    public ProductPhoto searchProductPhotoById(UUID idPhoto) {
        log.info("[start] ProductPhotoInfraRepository - searchProductPhotoById");
        Optional<ProductPhoto> photo = photoSpringDataMongo.findById(idPhoto);
        log.info("[finish] ProductPhotoInfraRepository - searchProductPhotoById");
        return photo.orElseThrow(() -> new RuntimeException("Foto não encontrada!"));
    }

    @Override
    public void deletePhotoById(UUID idPhoto) {
        log.info("[start] ProductPhotoInfraRepository - deletePhotoById");
        photoSpringDataMongo.deleteById(idPhoto);
        log.info("[finish] ProductPhotoInfraRepository - deletePhotoById");
    }
}
