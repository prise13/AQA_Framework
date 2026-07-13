package client;

import api_model.CreateOrganizationRequest;
import api_model.CreateOrganizationResponse;
import exception.ApiException;
import io.restassured.response.Response;

public class OrganizationApi {

    private final ApiClientRestAssured apiClient = new ApiClientRestAssured();

    private static final String ENDPOINT = "/organizations";

    public CreateOrganizationResponse createOrganization(CreateOrganizationRequest request) {
        Response response = apiClient.sendPost(ENDPOINT, request);

        if (response.statusCode() != 200) {
            throw new ApiException("Failed to create organization. Expected status is 200, but got " + response.statusCode() + " Response body: " + response.asPrettyString());
        }
        return response.as(CreateOrganizationResponse.class);
    }
}
