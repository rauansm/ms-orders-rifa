package br.com.xmob.orders.order.application.api;

import br.com.xmob.orders.order.domain.Order;
import br.com.xmob.orders.product.domain.Product;
import br.com.xmob.orders.user.domain.User;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderDetailsResponse {
    private OrderDetails order;
    private ProductDetails product;
    private UserDetails user;

    public OrderDetailsResponse(Order order, Product product, User user) {
        this.order = new OrderDetails(order);
        this.product = new ProductDetails(product);
        this.user = new UserDetails(user);
    }
}
