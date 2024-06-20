package br.com.xmob.orders.product.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Document(collection = "product")
public class Product {
    @Id
    private UUID id;
    private String title;
    private String subtitle;
    private String description;
    private Privacy privacy;
    private boolean showHome;
    private Status status;
    private boolean highlight;
    private BigDecimal price;
    private Integer min;
    private Integer max;
    private QuantityNumbers quantityTotalNumbers;
    private Integer quantityNumbersRemaining;
    private StatusDisplay textStatus;
    private LocalDateTime dateDraw;
    private String category;
    private List<String> awards;

    private List<Winner> winners;

}
