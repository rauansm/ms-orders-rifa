package br.com.xmob.orders.user.infra;

import br.com.xmob.orders.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class UserInfraRepository implements UserRepository {

    private final UserSpringDataMongo userSpringDataMongo;

    @Override
    public User save(User user) {
        log.info("[start] UserInfraRepository - save");
        try {
            userSpringDataMongo.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Usuário já cadastrado!");
        }
        log.info("[finish] UserInfraRepository - save");
        return user;
    }

    @Override
    public User searchUserById(UUID idUser) {
        log.info("[start] UserInfraRepository - searchUserById");
        Optional<User> user = userSpringDataMongo.findById(idUser);
        log.info("[finish] UserInfraRepository - searchUserById");
        return user.orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }
}
