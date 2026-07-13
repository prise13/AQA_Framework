package client;

import constants.Constants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiClientRestAssured {

    private final RequestSpecification specification;

    public ApiClientRestAssured() {
        specification = new RequestSpecBuilder()
                .setBaseUri(Constants.BASE_URL)
                .setContentType(ContentType.JSON)
                .addQueryParam("key", Constants.API_KEY)
                .addQueryParam("token", Constants.API_TOKEN)
                .build();
    }

    public Response sendGet(String endpoint) {
        return given()
                .spec(specification)
                .get(endpoint);
    }

    public Response sendPost(String endpoint, Object body) {
        return given()
                .spec(specification)
                .body(body)
                .post(endpoint);
    }

}
