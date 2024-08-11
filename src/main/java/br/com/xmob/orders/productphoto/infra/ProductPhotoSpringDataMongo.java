package br.com.xmob.orders.productphoto.infra;

import br.com.xmob.orders.productphoto.domain.ProductPhoto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductPhotoSpringDataMongo extends MongoRepository<ProductPhoto, UUID > {
    Optional<ProductPhoto> findByProductIdAndId(UUID idProduct, UUID idPhoto);

    List<ProductPhoto> findAllByProductId(UUID idProduct);
}
