package br.com.xmob.orders.product.domain;

import lombok.Getter;

@Getter
public enum StatusDisplay {
    BUY_JA("Adquira já!");

    private final String text;

    StatusDisplay(String text) {
        this.text = text;
    }
}

