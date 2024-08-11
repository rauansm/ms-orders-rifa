package br.com.xmob.orders.productphoto.application.api;

import br.com.xmob.orders.productphoto.domain.ProductPhoto;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class PhotoResponse {
    private UUID id;
    private String url;

    public PhotoResponse(ProductPhoto photo) {
        this.id = photo.getId();
        this.url = photo.getUrl();
    }
}
