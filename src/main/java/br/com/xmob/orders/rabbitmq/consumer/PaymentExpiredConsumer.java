package br.com.xmob.orders.rabbitmq.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class PaymentExpiredConsumer {

    @RabbitListener(queues = "${rabbitmq.consumer.payment-expired}")
    public void paymentExpiredEvent(@Payload PaymentEvent paymentEvent){
        log.info("[start] PaymentExpiredConsumer - paymentExpiredEvent");
        log.debug("[PaymentEvent] {}", paymentEvent);
        
        log.info("[finish] PaymentExpiredConsumer - paymentExpiredEvent");
    }
}
