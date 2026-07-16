package client;

import api_model.ArticleRequest;
import api_model.CreateArticleRequest;
import api_model.CreateArticleResponse;
import api_model.CreateOrganizationResponse;
import exception.ApiException;
import io.restassured.response.Response;

public class ArticleApi {

    private final ApiClientRestAssured apiClient = new ApiClientRestAssured();

    private static final String ENDPOINT = "/articles";

    public CreateArticleResponse createArticle(CreateArticleRequest createArticleRequest) {
        Response response = apiClient.sendPost(ENDPOINT, createArticleRequest);

        if (response.statusCode() != 200) {
            throw new ApiException("Failed to create article. Expected status is 200, but got " + response.statusCode() + " Response body: " + response.asPrettyString());
        }
        return response.as(CreateArticleResponse.class);
    }
}
