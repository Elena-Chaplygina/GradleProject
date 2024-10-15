package dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DTOCart {
    @JsonProperty("product_id")
    Integer productId;
    Integer quantity;

    public DTOCart(Integer productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
