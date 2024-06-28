package br.com.xmob.orders.order.infra;

import br.com.xmob.orders.order.domain.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Order searchOrderById(UUID idOrder) {
        log.info("[start] OrderInfraRepository - searchOrderById");
        Optional<Order> order = orderSpringDataMongo.findById(idOrder);
        log.info("[finish] OrderInfraRepository - searchOrderById");
        return order.orElseThrow(() -> new RuntimeException("Pedido não encontrado!"));
    }
}
