package br.com.xmob.orders.product.infra;

import br.com.xmob.orders.product.domain.Product;

public interface ProductRepository {
    Product save(Product product);
}
