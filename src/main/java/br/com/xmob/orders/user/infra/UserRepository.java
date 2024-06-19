package br.com.xmob.orders.user.infra;

import br.com.xmob.orders.user.domain.User;

import java.util.UUID;

public interface UserRepository {
    User save(User user);

    User searchUserById(UUID idUser);
}
