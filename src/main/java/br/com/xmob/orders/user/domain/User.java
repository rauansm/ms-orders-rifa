package br.com.xmob.orders.user.domain;

import br.com.xmob.orders.user.application.api.UserRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Document(collection = "user")
public class User {
    @Id
    private UUID id;
    private String name;
    @Indexed(unique = true)
    private String phone;
    private String email;
    @Indexed(unique = true)
    private String cpf;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(UserRequest userRequest) {
        this.id = UUID.randomUUID();
        this.name = userRequest.getName();
        this.phone = userRequest.getPhone();
        this.email = userRequest.getEmail();
        this.cpf = userRequest.getCpf();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}

