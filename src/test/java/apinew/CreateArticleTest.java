package apinew;

import api_model.ArticleRequest;
import api_model.CreateArticleRequest;
import api_model.CreateArticleResponse;
import client.ArticleApi;
import factory.TestDataFactory;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class CreateArticleTest {

    private final ArticleApi articleApi = new ArticleApi();

    public void shouldCreateArticleWithValidData() {
        // Create article
        String title = "testArticle4";
        String description = "test description";
        String body = "test body";
        CreateArticleRequest createArticleRequest = TestDataFactory.createArticleRequest(title, description, body);
        CreateArticleResponse createArticleResponse = articleApi.createArticle(createArticleRequest);
        // Check that response contains correct fields
        assertThat(createArticleResponse.getArticle())
                .isNotNull();
        assertThat(createArticleResponse.getArticle().getTitle())
                .isEqualTo(title);
        assertThat(createArticleResponse.getArticle().getDescription())
                .isEqualTo(description);
        assertThat(createArticleResponse.getArticle().getBody())
                .isEqualTo(body);

    }
}
