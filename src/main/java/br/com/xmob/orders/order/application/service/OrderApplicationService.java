package br.com.xmob.orders.order.application.service;

import br.com.xmob.orders.order.application.api.OrderRequest;
import br.com.xmob.orders.order.application.api.OrderResponse;
import br.com.xmob.orders.order.domain.Order;
import br.com.xmob.orders.order.infra.OrderRepository;
import br.com.xmob.orders.product.domain.Product;
import br.com.xmob.orders.product.infra.ProductInfraRepository;
import br.com.xmob.orders.product.infra.ProductRepository;
import br.com.xmob.orders.user.domain.User;
import br.com.xmob.orders.user.infra.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrderApplicationService implements OrderService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Transactional
    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        log.info("[start] OrderApplicationService - createOrder");
        log.debug("[OrderRequest] {}", orderRequest);
        User user = userRepository.searchUserById(orderRequest.getUserId());
        Product product = productRepository.searchProductById(orderRequest.getProductId());
        product.validatePurchaseConditions(orderRequest);
        Order order = new Order(orderRequest,user,product);
        orderRepository.save(order);
        productRepository.save(product);
        log.info("[finish] OrderApplicationService - createOrder");
        return null;
    }
}
