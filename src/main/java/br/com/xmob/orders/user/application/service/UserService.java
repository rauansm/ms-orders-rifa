package br.com.xmob.orders.user.application.service;

import br.com.xmob.orders.user.application.api.UserRequest;
import br.com.xmob.orders.user.application.api.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
}
