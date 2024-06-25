package br.com.xmob.orders.order.infra;

import br.com.xmob.orders.order.domain.PixResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "paymentPixFeignClient", url = "http://localhost:8083")
public interface PaymentPixFeignClient {

    @PostMapping("/api/v1/payment/cob")
    PixResponse createPixCharge(@RequestBody PixRequest pixRequest);
}
