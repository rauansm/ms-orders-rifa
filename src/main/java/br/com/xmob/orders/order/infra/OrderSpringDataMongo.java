package br.com.xmob.orders.order.infra;

import br.com.xmob.orders.order.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface OrderSpringDataMongo extends MongoRepository<Order, UUID> {
}
