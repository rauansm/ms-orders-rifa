package br.com.xmob.orders.rabbitmq.consumer;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class PaymentEvent {
        private UUID orderId;
        private String status;
}
