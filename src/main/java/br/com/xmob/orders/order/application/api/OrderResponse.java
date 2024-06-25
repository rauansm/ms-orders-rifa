package br.com.xmob.orders.order.application.api;

import br.com.xmob.orders.order.domain.Order;
import br.com.xmob.orders.order.domain.StatusOrder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@ToString
public class OrderResponse {
    private UUID id;
    private UUID productId;
    private UUID userId;
    private StatusOrder status;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal total;
    private List<String> numbers;
    private LocalDateTime expirationAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public OrderResponse(Order order) {
        this.id = order.getId();
        this.productId = order.getProductId();
        this.userId = order.getUserId();
        this.status = order.getStatus();
        this.quantity = order.getQuantity();
        this.price = order.getPrice();
        this.total = order.getTotal();
        this.numbers = order.getNumbers();
        this.expirationAt = order.getExpirationAt();
        this.createdAt = order.getCreatedAt();
        this.updatedAt = order.getUpdatedAt();
    }
}
