package br.com.xmob.orders.user.infra;

import br.com.xmob.orders.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

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
            throw new RuntimeException("Usuário já cadastrado");
        }
        log.info("[finish] UserInfraRepository - save");
        return user;
    }
}
