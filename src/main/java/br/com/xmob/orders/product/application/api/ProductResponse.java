package br.com.xmob.orders.product.application.api;

import br.com.xmob.orders.product.domain.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class ProductResponse {
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
    private String textStatus;
    private LocalDateTime dateDraw;
    private String category;
    private List<String> awards;
    private List<Winner> winners;

    public static ProductResponse from(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .title(product.getTitle())
                .subtitle(product.getSubtitle())
                .description(product.getDescription())
                .privacy(product.getPrivacy())
                .showHome(product.isShowHome())
                .status(product.getStatus())
                .highlight(product.isHighlight())
                .price(product.getPrice())
                .min(product.getMin())
                .max(product.getMax())
                .quantityTotalNumbers(product.getQuantityTotalNumbers())
                .quantityNumbersRemaining(product.getQuantityNumbersAvailable())
                .textStatus(product.getTextStatus().getText())
                .dateDraw(product.getDateDraw())
                .category(product.getCategory())
                .awards(product.getAwards())
                .winners(product.getWinners())
                .build();
    }
}
