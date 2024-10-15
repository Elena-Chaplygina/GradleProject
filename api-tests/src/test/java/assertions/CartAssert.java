package assertions;

import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;

public class CartAssert extends AbstractAssert<CartAssert, Response> {

    public CartAssert(Response actual) {
        super(actual, CartAssert.class);
    }

    public static CartAssert assertThat(Response actual) {
        return new CartAssert(actual);

    }


    public CartAssert checkCartSuccessMessage() {
        BasicAssert.assertThat(actual)
                .statusCodeIsEqual(201)
                .responseFieldIsEqual("message", "Product added to cart successfully");

        return this;
    }

}
