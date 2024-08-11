package br.com.xmob.orders.productphoto.application.api;

import br.com.xmob.orders.productphoto.application.service.ProductPhotoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/product/{idProduct}/photo")
public class ProductPhotoAPI {
    private final ProductPhotoService photoService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    void addProductPhoto(@PathVariable UUID idProduct, @RequestParam MultipartFile photo){
        log.info("[start] ProductPhotoAPI - addProductPhoto");
        photoService.addProductPhoto(idProduct,photo);
        log.info("[finish] ProductPhotoAPI - addProductPhoto");
    }
}
