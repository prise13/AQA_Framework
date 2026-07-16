package service;

import api_model.LoginRequest;
import api_model.LoginResponse;
import api_model.UserRequest;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import constants.Constants;
import exception.ApiException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Date;

import static io.restassured.RestAssured.given;

public class AuthService {

    private static final String LOGIN_ENDPOINT = "/users/login";

    private String token;

    private static final AuthService INSTANCE = new AuthService();

    private AuthService() {

    }

    public static AuthService getInstance() {
        return INSTANCE;
    }

    public String getToken() {
        if (token == null || isExpired(token)) {
            token = login();
        }
        return token;
    }

    private String login() {
        UserRequest userRequest = UserRequest.builder()
                .email(Constants.EMAIL)
                .password(Constants.PASSWORD)
                .build();
        LoginRequest loginRequest = LoginRequest.builder()
                .user(userRequest)
                .build();
        Response response = given().contentType(ContentType.JSON).baseUri(Constants.BASE_URL).body(loginRequest).post(LOGIN_ENDPOINT);
        if (response.statusCode() != 200) {
            throw new ApiException("Failed to get JWT, received status code " + response.statusCode() + " and body " + response.asPrettyString());
        }
        LoginResponse loginResponse = response.as(LoginResponse.class);
        return loginResponse.getUser().getToken();
    }

    private boolean isExpired(String token) {
        DecodedJWT jwt = JWT.decode(token);
        Date expiresAt = jwt.getExpiresAt();
        return expiresAt == null || expiresAt.before(new Date());
    }
}
