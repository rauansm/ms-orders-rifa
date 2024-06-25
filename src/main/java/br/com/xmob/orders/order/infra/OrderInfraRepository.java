package br.com.xmob.orders.order.infra;

import br.com.xmob.orders.order.domain.Order;
import br.com.xmob.orders.product.domain.Product;
import br.com.xmob.orders.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class OrderInfraRepository implements OrderRepository {

    private final OrderSpringDataMongo orderSpringDataMongo;

    @Override
    public void save(Order order) {
        log.info("[start] OrderInfraRepository - save");
        log.debug("[Order] {}", order);
        orderSpringDataMongo.save(order);
        log.info("[finish] OrderInfraRepository - save");
    }
}
