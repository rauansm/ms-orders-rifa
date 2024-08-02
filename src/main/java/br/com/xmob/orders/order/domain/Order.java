package br.com.xmob.orders.order.domain;

import br.com.xmob.orders.order.application.api.OrderRequest;
import br.com.xmob.orders.product.domain.Product;
import br.com.xmob.orders.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Document(collection = "order")
public class Order {
    @MongoId
    private UUID id;
    private UUID productId;
    private UUID userId;
    private StatusOrder status;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal total;
    private Set<String> numbers;
    private LocalDateTime expirationAt;
    private String paymentPIXQRCode;
    private String paymentPIXCopiaCola;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Order(OrderRequest orderRequest, User user, Product product) {
        this.id = UUID.randomUUID();
        this.productId = product.getId();
        this.userId = user.getId();
        this.status = StatusOrder.WAITING_PAYMENT;
        this.quantity = orderRequest.getQuantity();
        this.price = product.getPrice();
        this.total = calculatesTotalValue(orderRequest.getQuantity());
        this.numbers = new HashSet<>();
        this.createdAt = LocalDateTime.now();
        this.expirationAt = this.createdAt.plusMinutes(product.getPixExpirationTime());
        this.updatedAt = LocalDateTime.now();
    }

    private BigDecimal calculatesTotalValue(Integer quantity) {
        return this.price.multiply(new BigDecimal(quantity));
    }

    public void updatePixInfo(PixResponse pixResponse) {
        this.paymentPIXCopiaCola = pixResponse.getPaymentPIXCopiaCola();
        this.paymentPIXQRCode = pixResponse.getPaymentPIXQRCode();
    }

    public void updateNumbersAndStatus(Set<String> numbersOrder) {
        this.status = StatusOrder.PAID;
        this.numbers = numbersOrder;
        this.updatedAt = LocalDateTime.now();
    }
}
