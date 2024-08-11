package br.com.xmob.orders.productphoto.infra;

import br.com.xmob.orders.productphoto.domain.ProductPhoto;

public interface ProductPhotoRepository {
    ProductPhoto saveProductPhoto(ProductPhoto productPhoto);
}
