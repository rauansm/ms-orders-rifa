package br.com.xmob.orders.product.application.api;

import br.com.xmob.orders.product.domain.Privacy;
import br.com.xmob.orders.product.domain.QuantityNumbers;
import br.com.xmob.orders.product.domain.Status;
import br.com.xmob.orders.product.domain.StatusDisplay;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
public class ProductRequest {
    @NotBlank(message = "O campo título é obrigatório e não pode estar em branco.")
    private String title;
    @NotBlank(message = "O campo subtítulo é obrigatório e não pode estar em branco.")
    private String subtitle;
    private String description;
    private Privacy privacy = Privacy.PUBLIC;
    private boolean showHome = true;
    private Status status = Status.ACTIVE;
    private boolean highlight = false;
    @NotNull(message = "O campo preço é obrigatório e não pode ser nulo.")
    @Positive(message = "O valor do preço deve ser maior que zero.")
    private BigDecimal price;
    @NotNull(message = "A quantidade mínima de números comprados por vez deve ser definida.")
    private Integer min;
    @NotNull(message = "A quantidade máxima de números comprados por vez deve ser definida.")
    private Integer max;
    @NotNull(message = "A quantidade total de números deve ser escolhida.")
    private QuantityNumbers quantityTotalNumbers;
    private StatusDisplay textStatus = StatusDisplay.BUY_JA;
    private LocalDateTime dateDraw;
    private String category;
    @NotNull(message = "O campo prêmios é obrigatório e não pode estar em branco.")
    private List<String> awards;
}
