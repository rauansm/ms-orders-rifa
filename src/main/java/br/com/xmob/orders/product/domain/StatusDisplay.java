package br.com.xmob.orders.product.domain;

public enum StatusDisplay {
    BUY_JA("Adquira já!");

    private final String text;

    StatusDisplay(String text) {
        this.text = text;
    }
}

