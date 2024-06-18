package br.com.xmob.orders.user.application.api;

import br.com.xmob.orders.user.domain.User;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
public class UserDetailsResponse {
    private UUID id;
    private String name;
    private String phone;
    private String email;
    private String cpf;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserDetailsResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }
}
