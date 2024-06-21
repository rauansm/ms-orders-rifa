package br.com.xmob.orders.product.infra;

import br.com.xmob.orders.product.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Product searchProductById(UUID idProduct) {
        log.info("[start] ProductInfraRepository - searchProductById");
        Optional<Product> product = productSpringDataMongo.findById(idProduct);
        log.info("[finish] ProductInfraRepository - searchProductById");
        return product.orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }
}
