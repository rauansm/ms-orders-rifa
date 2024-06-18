package br.com.xmob.orders.user.application.api;

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
    private String cpf;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
