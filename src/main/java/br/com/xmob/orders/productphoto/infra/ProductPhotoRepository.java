package br.com.xmob.orders.productphoto.infra;

import br.com.xmob.orders.productphoto.domain.ProductPhoto;

import java.util.List;
import java.util.UUID;

public interface ProductPhotoRepository {
    ProductPhoto saveProductPhoto(ProductPhoto productPhoto);

    ProductPhoto searchProductPhotoById(UUID idProduct,UUID idPhoto);

    void deletePhotoById(UUID idPhoto);

    List<ProductPhoto> listAllProductPhotos(UUID idProduct);
}
