import assertions.BasicAssert;
import assertions.CartAssert;
import endpoints.AuthApi;
import endpoints.CartApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CartTests {

    CartApi cartApi;

    @BeforeEach
    void getAuthToken() {
        String token = AuthApi.loginUser("string","string").jsonPath().getString("access_token");
        cartApi = new CartApi(token);
    }

    @DisplayName("Проверка получения корзины клиента")
    @Test
    void verifyGettingClientCart() {
        Response response = cartApi.getCart();
        BasicAssert.assertThat(response).statusCodeIsEqual(200);

    }

    @DisplayName("Проверка добавления существующего продукта в карточку клиента")
    @Test
    void verifyAddingExistingProductToCart() {
        Response response = cartApi.addCart(1, 2);
        CartAssert.assertThat(response).checkCartSuccessMessage();

    }
    @AfterAll
    public static void tearDown() {
        RestAssured.reset();
    }
}
