package br.com.xmob.orders.productphoto.application.service;

import br.com.xmob.orders.productphoto.application.api.PhotoResponse;
import br.com.xmob.orders.productphoto.domain.ProductPhoto;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface ProductPhotoService {
    PhotoResponse addProductPhoto(UUID idProduct, MultipartFile photoRequest);

    void deleteProductPhoto(UUID idProduct, UUID idPhoto);

    ProductPhoto searchProductPhotoById(UUID idProduct, UUID idPhoto);
}
