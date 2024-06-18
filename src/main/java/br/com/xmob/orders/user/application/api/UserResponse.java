package br.com.xmob.orders.user.application.api;

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
}
