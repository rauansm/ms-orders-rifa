package br.com.xmob.orders.product.application.api;

import br.com.xmob.orders.product.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/product")
@Log4j2
@RequiredArgsConstructor
public class ProductAPI {

    private final ProductService productService;

    @PostMapping(value = "/new")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody @Valid ProductRequest productRequest){
        log.info("[start] ProductAPI - createProduct");
        log.debug("[ProductRequest] {}", productRequest);
        var productCreated = productService.createProduct(productRequest);
        log.info("[finish] ProductAPI - createProduct");
        return productCreated;
    }
}
