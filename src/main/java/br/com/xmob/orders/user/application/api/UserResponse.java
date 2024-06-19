package br.com.xmob.orders.user.application.api;

import br.com.xmob.orders.user.domain.User;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class UserResponse {
    private UUID id;
    private String name;
    private String phone;
    private String email;
    private String cpf;

    public UserResponse(User userNew) {
        this.id = userNew.getId();
        this.name = userNew.getName();
        this.phone = userNew.getPhone();
        this.email = userNew.getEmail();
        this.cpf = userNew.getCpf();
    }
}
