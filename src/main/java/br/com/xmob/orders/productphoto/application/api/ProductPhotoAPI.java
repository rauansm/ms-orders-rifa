package br.com.xmob.orders.productphoto.application.api;

import br.com.xmob.orders.productphoto.application.service.ProductPhotoService;
import br.com.xmob.orders.productphoto.domain.ProductPhoto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/product/{idProduct}/photo")
public class ProductPhotoAPI {
    private final ProductPhotoService photoService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    PhotoResponse addProductPhoto(@PathVariable UUID idProduct, @RequestParam MultipartFile photoRequest){
        log.info("[start] ProductPhotoAPI - addProductPhoto");
        var photoResponse = photoService.addProductPhoto(idProduct,photoRequest);
        log.info("[finish] ProductPhotoAPI - addProductPhoto");
        return photoResponse;
    }

    @GetMapping("/{idPhoto}")
    ResponseEntity<?> searchProductPhoto(@PathVariable UUID idProduct, @PathVariable UUID idPhoto){
        log.info("[start] ProductPhotoAPI - searchProductPhotoById");
        ProductPhoto photo = photoService.searchProductPhotoById(idProduct,idPhoto);
        log.info("[finish] ProductPhotoAPI - searchProductPhotoById");
        return  ResponseEntity
                .status(HttpStatus.FOUND)
                .header(HttpHeaders.LOCATION, photo.getUrl())
                .build();
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<PhotoResponse> listAllProductPhotos(@PathVariable UUID idProduct){
        log.info("[start] ProductPhotoAPI - listAllProductPhotos");
        List<PhotoResponse> photos = photoService.listAllProductPhotos(idProduct);
        log.info("[finish] ProductPhotoAPI - listAllProductPhotos");
        return photos;
    }

    @DeleteMapping("/{idPhoto}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteProductPhoto(@PathVariable UUID idProduct, @PathVariable UUID idPhoto){
        log.info("[start] ProductPhotoAPI - deleteProductPhoto");
        photoService.deleteProductPhoto(idProduct, idPhoto);
        log.info("[finish] ProductPhotoAPI - deleteProductPhoto");
    }
}
