package br.com.xmob.orders.productphoto.application.service;

import br.com.xmob.orders.product.domain.Product;
import br.com.xmob.orders.product.infra.ProductRepository;
import br.com.xmob.orders.productphoto.application.api.ProductPhotoAPI;
import br.com.xmob.orders.productphoto.domain.NewPhoto;
import br.com.xmob.orders.productphoto.domain.ProductPhoto;
import br.com.xmob.orders.productphoto.infra.PhotoStorage;
import br.com.xmob.orders.productphoto.infra.PhotoStorageS3;
import br.com.xmob.orders.productphoto.infra.ProductPhotoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductPhotoApplicationService implements ProductPhotoService {
    private final ProductRepository productRepository;
    private final ProductPhotoRepository photoRepository;
    private final PhotoStorage photoStorage;

    @Transactional
    @Override
    public void addProductPhoto(UUID idProduct, MultipartFile photo) {
        log.info("[start] ProductPhotoApplicationService - addProductPhoto");
        Product product = productRepository.searchProductById(idProduct);
        ProductPhoto savedPhoto = photoRepository.saveProductPhoto(new ProductPhoto(product, photo));
        URL urlPhoto = photoStorage.store(new NewPhoto(savedPhoto, photo));
        product.addUrlPhoto(urlPhoto);
        productRepository.save(product);
        log.info("[finish] ProductPhotoApplicationService - addProductPhoto");
    }
}
