package endpoints;

import dto.request.DTOUser;
import io.restassured.response.Response;
import utils.RestApiBuilder;

import static io.restassured.RestAssured.baseURI;

public class AuthApi extends BasicApi{

    public AuthApi(String token) {
        super(token);
    }


    public static Response loginUser(String username, String password) {

        return new RestApiBuilder(baseURI).build()
                .body(toJSON(new DTOUser(username,password)))
                .post(Urls.LOGIN);
    }
}
