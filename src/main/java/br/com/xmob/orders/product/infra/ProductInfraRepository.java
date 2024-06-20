package br.com.xmob.orders.product.infra;

import br.com.xmob.orders.product.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ProductInfraRepository implements ProductRepository {

    private final ProductSpringDataMongo productSpringDataMongo;

    @Override
    public Product save(Product product) {
        log.info("[start] ProductInfraRepository - save");
        productSpringDataMongo.save(product);
        log.info("[finish] ProductInfraRepository - save");
        return product;
    }
}
