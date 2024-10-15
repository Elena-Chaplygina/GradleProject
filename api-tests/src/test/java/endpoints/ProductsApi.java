package endpoints;

import dto.request.DTOProduct;
import io.restassured.response.Response;

public class ProductsApi extends BasicApi {


    public ProductsApi(String token) {
        super(token);
    }


    public Response getProductList() {
        return getBuilder().get(Urls.PRODUCTS);
    }

    public Response getProduct(Integer id) {
        return getBuilder().get(Urls.PRODUCTS + '/' + id);
    }

    public Response addNewProduct(String name, int discount, int price,String category) {
        return getBuilder()
                .body(toJSON(new DTOProduct(name,category, price,discount)))
                .post(Urls.PRODUCTS);

    }
}
