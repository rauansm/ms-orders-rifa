package br.com.xmob.orders.product.application.service;

import br.com.xmob.orders.product.application.api.ProductDetailsResponse;
import br.com.xmob.orders.product.application.api.ProductRequest;
import br.com.xmob.orders.product.application.api.ProductResponse;
import br.com.xmob.orders.product.domain.Product;
import br.com.xmob.orders.product.infra.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductApplicationService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        log.info("[start] ProductApplicationService - createProduct");
        log.debug("[ProductRequest] {}", productRequest);
        Product product = productRepository.save(new Product(productRequest));
        log.info("[finish] ProductApplicationService - createProduct");
        return ProductResponse.from(product);
    }

    @Override
    public ProductDetailsResponse searchProductById(UUID idProduct) {
        log.info("[start] ProductApplicationService - searchProductById");
        log.debug("[idProduct] {}", idProduct);
        Product product = productRepository.searchProductById(idProduct);
        log.info("[finish] ProductApplicationService - searchProductById");
        return ProductDetailsResponse.from(product);
    }
}
