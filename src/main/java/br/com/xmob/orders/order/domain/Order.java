package br.com.xmob.orders.order.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
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
    private List<String> numbers;
    private LocalDateTime expirationAt;
    private String paymentPIXQRCode;
    private String paymentPIXCopiaCola;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
