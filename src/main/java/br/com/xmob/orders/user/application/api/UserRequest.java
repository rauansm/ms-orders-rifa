package br.com.xmob.orders.user.application.api;

import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Getter
@ToString
public class UserRequest {
    @NotBlank(message = "nome não pode estar em branco.")
    private String name;
    @NotBlank(message = "telefone não pode estar em branco.")
    @Pattern(regexp = "^\\(?\\d{2}\\)?\\s?9\\d{4}-?\\d{4}$", message = "número de telefone inválido")
    private String phone;
    @Email
    private String email;
    @NotBlank(message = "cpf não pode estar em branco.")
    @CPF(message = "cpf inválido")
    private String cpf;
}
