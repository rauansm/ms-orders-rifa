package br.com.xmob.orders.productphoto.application.service;

import br.com.xmob.orders.product.domain.Product;
import br.com.xmob.orders.product.infra.ProductRepository;
import br.com.xmob.orders.productphoto.application.api.PhotoResponse;
import br.com.xmob.orders.productphoto.domain.NewPhoto;
import br.com.xmob.orders.productphoto.domain.ProductPhoto;
import br.com.xmob.orders.productphoto.infra.PhotoStorage;
import br.com.xmob.orders.productphoto.infra.ProductPhotoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.util.List;
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
    public PhotoResponse addProductPhoto(UUID idProduct, MultipartFile photoRequest) {
        log.info("[start] ProductPhotoApplicationService - addProductPhoto");
        Product product = productRepository.searchProductById(idProduct);
        ProductPhoto photo = new ProductPhoto(product, photoRequest);
        URL urlPhoto = photoStorage.store(new NewPhoto(photo, photoRequest));
        product.addUrlPhoto(urlPhoto);
        photo.addUrl(urlPhoto);
        photoRepository.saveProductPhoto(photo);
        productRepository.save(product);
        log.info("[finish] ProductPhotoApplicationService - addProductPhoto");
        return new PhotoResponse(photo);
    }

    @Override
    public ProductPhoto searchProductPhotoById(UUID idProduct, UUID idPhoto) {
        log.info("[start] ProductPhotoApplicationService - searchProductPhotoById");
        Product product = productRepository.searchProductById(idProduct);
        ProductPhoto photo = photoRepository.searchProductPhotoById(product.getId(), idPhoto);
        log.info("[finish] ProductPhotoApplicationService - searchProductPhotoById");
        return photo;
    }

    @Override
    public List<PhotoResponse> listAllProductPhotos(UUID idProduct) {
        log.info("[start] ProductPhotoApplicationService - listAllProductPhotos");
        List<ProductPhoto> photos = photoRepository.listAllProductPhotos(idProduct);
        log.info("[finish] ProductPhotoApplicationService - listAllProductPhotos");
        return PhotoResponse.convert(photos);
    }

    @Transactional
    @Override
    public void deleteProductPhoto(UUID idProduct, UUID idPhoto) {
        log.info("[start] ProductPhotoApplicationService - deleteProductPhoto");
        Product product = productRepository.searchProductById(idProduct);
        ProductPhoto photo = photoRepository.searchProductPhotoById(product.getId(),idPhoto);
        photoStorage.remove(photo.getFilename());
        product.removeUrlPhoto(photo.getUrl());
        photoRepository.deletePhotoById(photo.getId());
        productRepository.save(product);
        log.info("[finish] ProductPhotoApplicationService - deleteProductPhoto");
    }
}
