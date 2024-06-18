package br.com.xmob.orders.user.infra;

import br.com.xmob.orders.user.domain.User;

public interface UserRepository {
    User save(User user);
}
