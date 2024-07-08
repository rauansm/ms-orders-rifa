package br.com.xmob.orders.order.application.service;

import br.com.xmob.orders.order.domain.Order;
import br.com.xmob.orders.order.domain.PixResponse;
import br.com.xmob.orders.product.domain.Product;
import br.com.xmob.orders.user.domain.User;

public interface PixClientRest {
    PixResponse createPixCharge(Order order, User user, Product product);
}
