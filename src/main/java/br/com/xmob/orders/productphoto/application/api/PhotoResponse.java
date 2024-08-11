package br.com.xmob.orders.productphoto.application.api;

import br.com.xmob.orders.productphoto.domain.ProductPhoto;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@ToString
public class PhotoResponse {
    private UUID id;
    private String url;

    public PhotoResponse(ProductPhoto photo) {
        this.id = photo.getId();
        this.url = photo.getUrl();
    }

    public static List<PhotoResponse> convert(List<ProductPhoto> photos) {
        return photos.stream()
                .map(PhotoResponse::new)
                .collect(Collectors.toList());
    }
}
