package br.com.xmob.orders.user.infra;

import br.com.xmob.orders.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserSpringDataMongo extends MongoRepository<User, UUID> {
}
