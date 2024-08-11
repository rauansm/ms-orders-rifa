package br.com.xmob.orders.product.domain;

import lombok.Getter;

@Getter
public enum Privacy {
    PUBLIC("public"),
    PRIVATE("private");

    private final String text;

    Privacy(String text) {
        this.text = text;
    }
}
