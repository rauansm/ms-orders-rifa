package br.com.xmob.orders.user.application.api;

import br.com.xmob.orders.user.application.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/user")
@Log4j2
@RequiredArgsConstructor
public class UserAPI {

    private final UserService userService;

    @PostMapping(value = "/new")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody @Valid UserRequest userRequest){
        log.info("[start] UserAPI - createUser");
        log.debug("[UserRequest] {}", userRequest);
        var userCreated = userService.createUser(userRequest);
        log.info("[finish] UserAPI - createUser");
        return userCreated;
    }

    @GetMapping("/{idUser}")
    @ResponseStatus(code = HttpStatus.OK)
    public UserDetailsResponse searchUserById(@PathVariable UUID idUser){
        log.info("[start] UserAPI - searchUserById");
        log.debug("[idUser] {}", idUser);
        var userDetails = userService.searchUserById(idUser);
        log.info("[finish] UserAPI - searchUserById");
        return userDetails;
    }
}
