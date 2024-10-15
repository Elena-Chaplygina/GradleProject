package dto.request;

import lombok.*;

@Builder
@Getter

public class DTOProduct {
    String name;
    String category;
    double price;
    double discount;

    public DTOProduct(String name, String category, double price, double discount) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.discount = discount;
    }
}
