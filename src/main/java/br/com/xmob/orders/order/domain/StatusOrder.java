package br.com.xmob.orders.order.domain;

import lombok.Getter;

@Getter
public enum StatusOrder {
    WAITING_PAYMENT("waiting-payment"),
    PAID("paid"),
    EXPIRED("expired");

    private final String text;

    StatusOrder(String text) {
        this.text = text;
    }
}
