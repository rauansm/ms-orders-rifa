package br.com.xmob.orders.order.infra;

import br.com.xmob.orders.order.application.service.PixClientRest;
import br.com.xmob.orders.order.domain.Order;
import br.com.xmob.orders.order.domain.PixResponse;
import br.com.xmob.orders.product.domain.Product;
import br.com.xmob.orders.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class PixInfraClientRest implements PixClientRest {
    private final PaymentPixFeignClient paymentPixFeignClient;

    @Override
    public PixResponse createPixCharge(Order order, User user, Product product) {
        log.info("[start] PixInfraClientRest - createPixCharge");
        log.debug("[Order] {} [User] {}", order,user);
        PixResponse pixResponse = paymentPixFeignClient.createPixCharge(new PixRequest(order,user,product));
        log.debug("[PixResponse] {}", pixResponse);
        log.info("[finish] PixInfraClientRest - createPixCharge");
        return pixResponse;
    }
}
