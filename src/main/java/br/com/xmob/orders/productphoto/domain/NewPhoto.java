package br.com.xmob.orders.productphoto.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Getter
@AllArgsConstructor
public class NewPhoto {
    private String filename;
    private String contentType;
    private InputStream inputStream;

    @SneakyThrows
    public NewPhoto(ProductPhoto savedPhoto, MultipartFile photoRequest) {
        this.filename = savedPhoto.getFilename();
        this.contentType = savedPhoto.getContentType();
        this.inputStream = photoRequest.getInputStream();
    }
}
