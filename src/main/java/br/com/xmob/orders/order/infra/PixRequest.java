package br.com.xmob.orders.order.infra;

import br.com.xmob.orders.order.domain.Order;
import br.com.xmob.orders.user.domain.User;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@ToString
public class PixRequest {
    private String name;
    private String cpf;
    private BigDecimal amount;
    private UUID orderId;

    public PixRequest(Order order, User user) {
        this.name = user.getName();
        this.cpf = user.getCpf();
        this.amount = order.getTotal();
        this.orderId = order.getId();
    }
}
