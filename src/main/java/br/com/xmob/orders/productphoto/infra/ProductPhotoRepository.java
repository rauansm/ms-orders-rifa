package br.com.xmob.orders.productphoto.infra;

import br.com.xmob.orders.productphoto.domain.ProductPhoto;

import java.util.UUID;

public interface ProductPhotoRepository {
    ProductPhoto saveProductPhoto(ProductPhoto productPhoto);

    ProductPhoto searchProductPhotoById(UUID idPhoto);

    void deletePhotoById(UUID idPhoto);
}
