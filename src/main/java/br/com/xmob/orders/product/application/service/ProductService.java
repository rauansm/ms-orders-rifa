package br.com.xmob.orders.product.application.service;

import br.com.xmob.orders.product.application.api.ProductDetailsResponse;
import br.com.xmob.orders.product.application.api.ProductRequest;
import br.com.xmob.orders.product.application.api.ProductResponse;

import java.util.UUID;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);

    ProductDetailsResponse searchProduct(UUID idProduct);
}
