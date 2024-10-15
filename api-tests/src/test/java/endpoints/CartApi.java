package endpoints;

import dto.request.DTOCart;
import io.restassured.response.Response;

public class CartApi extends BasicApi {


    public CartApi(String token) {
        super(token);
    }

    public Response getCart() {
        return getBuilder().get(Urls.CART);
    }

    public Response addCart(int productId, int quantity) {
        return getBuilder()
                .body(toJSON(new DTOCart(productId,quantity)))
                .post(Urls.CART);
    }

}
