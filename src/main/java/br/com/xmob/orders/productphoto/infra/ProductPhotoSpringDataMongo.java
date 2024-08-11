package br.com.xmob.orders.productphoto.infra;

import br.com.xmob.orders.productphoto.domain.ProductPhoto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ProductPhotoSpringDataMongo extends MongoRepository<ProductPhoto, UUID > {
}
