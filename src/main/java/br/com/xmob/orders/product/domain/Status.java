package br.com.xmob.orders.product.domain;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("active"),
    PAUSED("paused"),
    DONE("done");

    private final String text;

    Status(String text) {
        this.text = text;
    }
}
