package assertions;

import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;

public class ProductsAssert extends AbstractAssert<ProductsAssert, Response> {
    protected ProductsAssert(Response actual) {
        super(actual, ProductsAssert.class);
    }


    public static ProductsAssert assertThat(Response actual) {
        return new ProductsAssert(actual);

    }

    public ProductsAssert checkProductResponse(String category, String id) {
        BasicAssert.assertThat(actual)
                .statusCodeIsEqual(200)
                .responseFieldIsEqual("[0].category", category)
                .responseFieldIsEqual("[0].id", id);

        return this;
    }
}
