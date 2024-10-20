import assertions.BasicAssert;
import assertions.ProductsAssert;
import endpoints.AuthApi;
import endpoints.ProductsApi;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ProductsTest {

    ProductsApi productsApi;

    @BeforeEach
    void getAuthToken() {
        String token = AuthApi.loginUser("string", "string").jsonPath().getString("access_token");
        productsApi = new ProductsApi(token);
    }

    @DisplayName("Проверка получения списка продуктов")
    @Test
    void verifyGetAllProductsReturnsList() {
        Response response = productsApi.getProductList();
        BasicAssert.assertThat(response).statusCodeIsEqual(200);
    }

    @DisplayName("Проверка поиска продукта по id")
    @Test
    void verifyProductFoundForValidId() {
        Response response = productsApi.getProduct(1);
        ProductsAssert.assertThat(response).checkProductResponse("Electronics", "1");
    }

    @DisplayName("Проверка добавления продукта")
    @Test
    void verifyProductAdded() {
        Response response = productsApi.addNewProduct("Laptop", 6, 10, "Electronics");
        BasicAssert.assertThat(response).statusCodeIsEqual(201);
    }
}


