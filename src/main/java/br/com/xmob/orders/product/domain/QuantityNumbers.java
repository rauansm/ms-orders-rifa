package br.com.xmob.orders.product.domain;

import lombok.Getter;

@Getter
public enum QuantityNumbers {
    ONE_MILLION(1000000),
    TEN_MILLION(10000000);

    private final int value;

    QuantityNumbers(int value) {
        this.value = value;
    }

}
