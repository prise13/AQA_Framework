package client;

import constants.Constants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import service.AuthService;

import static io.restassured.RestAssured.given;

public class ApiClientRestAssured {

    private final AuthService authService = AuthService.getInstance();

    private RequestSpecification request() {
        return given()
                .baseUri(Constants.BASE_URL)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + authService.getToken());
    }

    public Response sendGet(String endpoint) {
        return request()
                .get(endpoint);
    }

    public Response sendPost(String endpoint, Object body) {
        return request()
                .body(body)
                .post(endpoint);
    }

}
