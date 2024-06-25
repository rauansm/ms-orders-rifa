package br.com.xmob.orders.order.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PixResponse {
    private String paymentPIXCopiaCola;
    private String paymentPIXQRCode;
}
