package br.com.xmob.orders.order.application.service;

import br.com.xmob.orders.order.application.api.OrderRequest;
import br.com.xmob.orders.order.application.api.OrderResponse;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);
}
