package br.com.xmob.orders.product.application.service;

import br.com.xmob.orders.product.application.api.ProductDetailsResponse;
import br.com.xmob.orders.product.application.api.ProductRequest;
import br.com.xmob.orders.product.application.api.ProductResponse;
import br.com.xmob.orders.product.domain.Product;
import br.com.xmob.orders.product.infra.ProductRepository;
import br.com.xmob.orders.user.infra.UserInfraRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ProductDetailsResponse searchProduct(UUID idProduct) {
        log.info("[start] ProductApplicationService - searchProduct");
        log.debug("[idProduct] {}", idProduct);

        log.info("[finish] ProductApplicationService - searchProduct");
        return null;
    }
}
