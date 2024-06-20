package br.com.xmob.orders.product.domain;

import br.com.xmob.orders.product.application.api.ProductRequest;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<String> awards;

    private List<Winner> winners;

    public Product(ProductRequest productRequest) {
        this.id = UUID.randomUUID();
        this.title = productRequest.getTitle();
        this.subtitle = productRequest.getSubtitle();
        this.description = productRequest.getDescription();
        this.privacy = productRequest.getPrivacy();
        this.showHome = productRequest.isShowHome();
        this.status = productRequest.getStatus();
        this.highlight = productRequest.isHighlight();
        this.price = productRequest.getPrice();
        this.min = productRequest.getMin();
        this.max = productRequest.getMax();
        this.quantityTotalNumbers = productRequest.getQuantityTotalNumbers();
        this.quantityNumbersRemaining = productRequest.getQuantityTotalNumbers().getValue();
        this.textStatus = productRequest.getTextStatus();
        this.dateDraw = productRequest.getDateDraw();
        this.category = productRequest.getCategory();
        this.awards = productRequest.getAwards();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.winners = new ArrayList<>();
    }
}
