package br.com.xmob.orders.user.application.service;

import br.com.xmob.orders.user.application.api.UserDetailsResponse;
import br.com.xmob.orders.user.application.api.UserRequest;
import br.com.xmob.orders.user.application.api.UserResponse;

import java.util.UUID;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);

    UserDetailsResponse searchUserById(UUID idUser);
}
