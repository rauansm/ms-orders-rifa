package br.com.xmob.orders.product.infra;

import br.com.xmob.orders.product.domain.Product;

import java.util.UUID;

public interface ProductRepository {
    Product save(Product product);

    Product searchProductById(UUID idProduct);
}
