package br.com.xmob.orders.order.application.service;

import br.com.xmob.orders.order.domain.Order;
import br.com.xmob.orders.product.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
@Log4j2
@RequiredArgsConstructor
public class NumberGenerationApplicationService implements NumberGenerationService {
    private final Random random;

    @Override
    public Set<String> generateNumbers(Set<String> numbersInUse, Order order, Product product) {
        log.info("[start] NumberGenerationApplicationService - generateNumbers");
        Set<String> numbersGerados = new HashSet<>();

        while (numbersGerados.size() < order.getQuantity()) {
            String number = String.format("%07d", random.nextInt(product.getQuantityTotalNumbers().getValue()));

            if (!numbersInUse.contains(number)) {
                numbersGerados.add(number);
            }
        }
        log.info("[finish] NumberGenerationApplicationService - generateNumbers");
        return numbersGerados;
    }
}
