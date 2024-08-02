package br.com.xmob.orders.rabbitmq.consumer;

import br.com.xmob.orders.order.application.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class PaymentConfirmedConsumer {
    private final OrderService orderService;

    @RabbitListener(queues = "${rabbitmq.consumer.payment-confirmed}")
    public void paymentConfirmedEvent(@Payload PaymentEvent paymentEvent){
        log.info("[start] PaymentConfirmedConsumer - paymentConfirmedEvent");
        log.debug("[PaymentEvent] {}", paymentEvent);
        orderService.processOrderPaymentConfirmation(paymentEvent.getOrderId());
        log.info("[finish] PaymentEventConsumer - paymentConfirmedEvent");
    }
}
