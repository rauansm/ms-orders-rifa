package br.com.xmob.orders.order.infra;

import br.com.xmob.orders.order.domain.Order;

import java.util.UUID;

public interface OrderRepository {
    void save(Order order);

    Order searchOrderById(UUID idOrder);
}
