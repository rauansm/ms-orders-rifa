package br.com.xmob.orders.order.application.service;

import br.com.xmob.orders.order.domain.Order;
import br.com.xmob.orders.product.domain.Product;

import java.util.Set;

public interface NumberGenerationService {
    Set<String> generateNumbers(Set<String> numbersInUse, Order order, Product product);
}
