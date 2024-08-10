package br.com.xmob.orders.order.infra;

import br.com.xmob.orders.order.domain.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
@Log4j2
@RequiredArgsConstructor
public class OrderInfraRepository implements OrderRepository {
    private final OrderSpringDataMongo orderSpringDataMongo;
    private final MongoTemplate mongoTemplate;

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

    @Override
    public Set<String> searchNumbersInUseByProductId(UUID productId) {
        log.info("[start] OrderInfraRepository - searchNumbersInUseByOrderId");

        AggregationOperation match = match(Criteria.where("productId").is(productId));

        AggregationOperation project = project("numbers");

        Aggregation aggregation = newAggregation(match, project);

        AggregationResults<OrderNumbersProjection> results = mongoTemplate.aggregate(
                aggregation, "order", OrderNumbersProjection.class);

        log.info("[finish] OrderInfraRepository - searchNumbersInUseByOrderId");
        return results.getMappedResults().stream()
                .flatMap(projection -> projection.getNumbers().stream())
                .collect(Collectors.toSet());
    }
}
