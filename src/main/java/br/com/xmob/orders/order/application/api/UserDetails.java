package br.com.xmob.orders.order.application.api;

import br.com.xmob.orders.user.domain.User;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserDetails {
    private String name;
    private String phone;
    private String cpf;

    public UserDetails(User user) {
        this.name = user.getName();
        this.phone = user.getPhone().substring(0, 7) + "****";
        this.cpf = user.getCpf().substring(0, 3) + "********";
    }
}
