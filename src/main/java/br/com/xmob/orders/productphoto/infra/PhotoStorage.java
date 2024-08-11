package br.com.xmob.orders.productphoto.infra;

import br.com.xmob.orders.productphoto.domain.NewPhoto;

import java.net.URL;

public interface PhotoStorage {
    URL store(NewPhoto photo);
}
