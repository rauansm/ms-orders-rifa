package br.com.xmob.orders.order.application.service;

import br.com.xmob.orders.order.application.api.OrderDetailsResponse;
import br.com.xmob.orders.order.application.api.OrderRequest;
import br.com.xmob.orders.order.application.api.OrderResponse;

import java.util.UUID;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);

    OrderDetailsResponse searchOrderDetailsById(UUID idOrder);
}
