package br.com.xmob.orders.order.application.api;

import br.com.xmob.orders.order.application.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/order")
@Log4j2
@RequiredArgsConstructor
public class OrderAPI {

    private final OrderService orderService;

    @PostMapping(value = "/new")
    @ResponseStatus(code = HttpStatus.CREATED)
    public OrderResponse createOrder(@RequestBody @Valid OrderRequest orderRequest){
        log.info("[start] OrderAPI - createOrder");
        log.debug("[OrderRequest] {}", orderRequest);
        var orderCreated = orderService.createOrder(orderRequest);
        log.info("[finish] OrderAPI - createOrder");
        return orderCreated;
    }
}
