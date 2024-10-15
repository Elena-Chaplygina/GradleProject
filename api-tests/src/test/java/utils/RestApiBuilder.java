package utils;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestApiBuilder {
    private final RequestSpecification requestSpecification;

    static {
        RestAssured.filters(new RequestLoggingFilter(System.out), new ResponseLoggingFilter(System.out));
        RestAssured.baseURI = "http://9b142cdd34e.vps.myjino.ru:49268";
    }

    public RestApiBuilder(String baseUrl) {
        requestSpecification = given().baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .config(RestAssuredConfig
                        .config()
                        .httpClient(HttpClientConfig
                                .httpClientConfig()
                                .setParam("http.connection.timeout", 5000)
                        )
                )
                .relaxedHTTPSValidation();
    }


    public RequestSpecification build() {
        return requestSpecification;
    }

    public RestApiBuilder addAuth(String token) {
        requestSpecification.header("Authorization", "Bearer " + token);

        return this;
    }

}
