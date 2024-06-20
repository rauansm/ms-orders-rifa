package br.com.xmob.orders.product.application.service;

import br.com.xmob.orders.product.application.api.ProductRequest;
import br.com.xmob.orders.product.application.api.ProductResponse;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);
}
