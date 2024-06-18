package br.com.xmob.orders.user.application.service;

import br.com.xmob.orders.user.application.api.UserRequest;
import br.com.xmob.orders.user.application.api.UserResponse;
import br.com.xmob.orders.user.domain.User;
import br.com.xmob.orders.user.infra.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserApplicationService implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        log.info("[start] UserApplicationService - createUser");
        log.debug("[UserRequest] {}", userRequest);
        User userNew = userRepository.save(new User(userRequest));
        log.info("[finish] UserApplicationService - createUser");
        return new UserResponse(userNew);
    }
}
