package br.com.xmob.orders.product.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class Winner {
    private String name;
    private String number;
    private String drawDate;
    private String award;
}
