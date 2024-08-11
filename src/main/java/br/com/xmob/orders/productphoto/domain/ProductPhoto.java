package br.com.xmob.orders.productphoto.domain;

import br.com.xmob.orders.product.domain.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "product_photo")
public class ProductPhoto {

    @Id
    private UUID id;
    private UUID productId;
    private String filename;
    private String contentType;
    private Long size;

    public ProductPhoto(Product product, MultipartFile photo) {
        this.id = UUID.randomUUID();
        this.productId = product.getId();
        this.contentType = photo.getContentType();
        this.size = photo.getSize();
        this.filename = photo.getOriginalFilename();
    }
}
