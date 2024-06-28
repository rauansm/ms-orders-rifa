package br.com.xmob.orders.order.application.api;

import br.com.xmob.orders.product.domain.Product;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductDetails {
    private String title;
    private String subtitle;
    private String status;
    private String textStatus;

    public ProductDetails(Product product) {
        this.title = product.getTitle();
        this.subtitle = product.getSubtitle();
        this.status = product.getStatus().getText();
        this.textStatus = product.getTextStatus().getText();
    }
}
