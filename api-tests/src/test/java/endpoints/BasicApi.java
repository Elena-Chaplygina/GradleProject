package endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.specification.RequestSpecification;
import utils.RestApiBuilder;

import static io.restassured.RestAssured.baseURI;

public class BasicApi {
    protected String token;


    public BasicApi(String token) {
        this.token = token;
    }

    public RequestSpecification getBuilder() {
        return new RestApiBuilder(baseURI).addAuth(token).build();
    }

    protected static String toJSON(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
