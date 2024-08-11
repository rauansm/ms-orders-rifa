package br.com.xmob.orders.productphoto.infra;

import br.com.xmob.orders.productphoto.domain.ProductPhoto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

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
}
