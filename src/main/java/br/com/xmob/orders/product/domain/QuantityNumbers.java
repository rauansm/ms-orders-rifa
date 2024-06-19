package br.com.xmob.orders.product.domain;

public enum QuantityNumbers {
    ONE_MILLION(1000000),
    TEN_MILLION(10000000);

    private final int value;

    QuantityNumbers(int value) {
        this.value = value;
    }

}
