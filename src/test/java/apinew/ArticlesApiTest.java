package apinew;

import api_model.CreateArticleRequest;
import api_model.CreateArticleResponse;
import client.ArticleApi;
import factory.TestDataFactory;
import helpers.AssertionHelper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class ArticlesApiTest {

    private final ArticleApi articleApi = new ArticleApi();

    public void shouldCreateArticleWithValidData() {
        // Create article
        CreateArticleRequest createArticleRequest = TestDataFactory.createDefaultArticleRequest();
        CreateArticleResponse createdArticle = articleApi.createArticle(createArticleRequest);
        // Check that response contains correct fields
        AssertionHelper.assertArticle(createdArticle.getArticle(), createArticleRequest.getArticle());
        // Get article by slug and check fields again, check that article from created is the same as in loaded
        CreateArticleResponse loadedArticle = articleApi.getArticleBySlug(createdArticle.getArticle().getSlug());
        AssertionHelper.assertArticle(loadedArticle.getArticle(), createArticleRequest.getArticle());
        AssertionHelper.assertSameArticle(loadedArticle.getArticle(), createdArticle.getArticle());
    }

    public void shouldNotCreateArticleWithoutTitle() {
        // Attempt to create Article without title
        CreateArticleRequest createArticleRequest = TestDataFactory.createArticleWithoutTitleRequest();
        Response response = articleApi.createArticleRaw(createArticleRequest);
        // BUG: API returns 500 instead of validation error 400
        assertThat(response.statusCode()).isEqualTo(500);
    }
}
