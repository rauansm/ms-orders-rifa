package br.com.xmob.orders.order.application.api;

import br.com.xmob.orders.order.domain.Order;
import br.com.xmob.orders.order.domain.StatusOrder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@ToString
public class OrderDetails {
    private UUID id;
    private UUID productId;
    private UUID userId;
    private String status;
    private Integer quantity;
    private BigDecimal total;
    private Set<String> numbers;
    private String paymentPIXQRCode;
    private String paymentPIXCopiaCola;
    private LocalDateTime createdAt;
    private LocalDateTime expirationAt;

    public OrderDetails(Order order) {
        this.id = order.getId();
        this.productId = order.getProductId();
        this.userId = order.getUserId();
        this.status = order.getStatus().getText();
        this.quantity = order.getQuantity();
        this.total = order.getTotal();
        this.numbers = order.getNumbers();
        this.paymentPIXCopiaCola = order.getPaymentPIXCopiaCola();
        this.paymentPIXQRCode = order.getPaymentPIXQRCode();
        this.createdAt = order.getCreatedAt();
        this.expirationAt = order.getExpirationAt();

    }
}
