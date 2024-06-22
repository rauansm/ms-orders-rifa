package br.com.xmob.orders.order.infra;

import br.com.xmob.orders.order.domain.Order;

public interface OrderRepository {
    void save(Order order);
}
