package br.com.xmob.orders.user.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;
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
    private OffsetDateTime createdAt;
}

