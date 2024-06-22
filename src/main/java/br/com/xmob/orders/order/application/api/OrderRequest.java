package br.com.xmob.orders.order.application.api;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class OrderRequest {
    private UUID productId;
    private UUID userId;
    private Integer quantity;
}
