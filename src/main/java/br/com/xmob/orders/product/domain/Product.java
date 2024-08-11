package br.com.xmob.orders.product.domain;

import br.com.xmob.orders.order.application.api.OrderRequest;
import br.com.xmob.orders.product.application.api.ProductRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.net.URL;
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
    private List<String> imageUrls;
    private Status status;
    private boolean highlight;
    private BigDecimal price;
    private Integer min;
    private Integer max;
    private QuantityNumbers quantityTotalNumbers;
    private Integer quantityNumbersAvailable;
    private StatusDisplay textStatus;
    private LocalDateTime dateDraw;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer pixExpirationTime;
    private List<String> awards;
    private List<Winner> winners;
    @Version
    private Long version;

    public Product(ProductRequest productRequest) {
        this.id = UUID.randomUUID();
        this.title = productRequest.getTitle();
        this.subtitle = productRequest.getSubtitle();
        this.description = productRequest.getDescription();
        this.privacy = productRequest.getPrivacy();
        this.showHome = productRequest.isShowHome();
        this.imageUrls = new ArrayList<>();
        this.status = productRequest.getStatus();
        this.highlight = productRequest.isHighlight();
        this.price = productRequest.getPrice();
        this.min = productRequest.getMin();
        this.max = productRequest.getMax();
        this.quantityTotalNumbers = productRequest.getQuantityTotalNumbers();
        this.quantityNumbersAvailable = productRequest.getQuantityTotalNumbers().getValue();
        this.textStatus = productRequest.getTextStatus();
        this.dateDraw = productRequest.getDateDraw();
        this.category = productRequest.getCategory();
        this.pixExpirationTime = productRequest.getPixExpirationTime();
        this.awards = productRequest.getAwards();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.winners = new ArrayList<>();
    }

    public void validatePurchaseConditions(OrderRequest orderRequest) {
        checkActiveProduct();
        checkAvailableNumbers(orderRequest.getQuantity());
        validatesMinAndMaxQuantity(orderRequest.getQuantity());
        updatesAvailableNumbers(orderRequest.getQuantity());
    }

    private void updatesAvailableNumbers(Integer quantity) {
        this.quantityNumbersAvailable -= quantity;
        this.updatedAt = LocalDateTime.now();
    }

    private void validatesMinAndMaxQuantity(Integer quantityOrder) {
        if (quantityOrder < this.min || quantityOrder > this.max){
            String mensagem = (quantityOrder < this.min)
                    ? "A quantidade do pedido não pode ser inferior à quantidade mínima permitida: " + this.min
                    : "A quantidade do pedido não pode ser maior que a quantidade máxima permitida: " + this.max;
            throw new RuntimeException(mensagem);
        }
    }

    private void checkAvailableNumbers(Integer quantityOrder) {
        if (quantityOrder > this.quantityNumbersAvailable){
            throw new RuntimeException("Produto não possui quantidade suficiente!");
        }
    }

    private void checkActiveProduct() {
        if (!this.status.equals(Status.ACTIVE)){
            throw new RuntimeException("O produto informado não está ativo.");
        }
    }

    public void performsRollbackOfAvailableQuantity(Integer quantity) {
        this.quantityNumbersAvailable += quantity;
        this.updatedAt = LocalDateTime.now();
    }

    public void addUrlPhoto(URL urlPhoto) {
        this.imageUrls.add(String.valueOf(urlPhoto));
        this.updatedAt = LocalDateTime.now();
    }
}
