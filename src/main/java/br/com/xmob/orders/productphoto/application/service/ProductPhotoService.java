package br.com.xmob.orders.productphoto.application.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface ProductPhotoService {
    void addProductPhoto(UUID idProduct, MultipartFile photoRequest);

    void deleteProductPhoto(UUID idProduct, UUID idPhoto);
}
