package br.com.xmob.orders.product.infra;

import br.com.xmob.orders.product.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ProductSpringDataMongo extends MongoRepository<Product, UUID> {
}
