package helpers;

import api_model.ArticleRequest;
import api_model.ArticleResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionHelper {

    public static void assertArticle(
            ArticleResponse actual, ArticleRequest expected) {

        assertThat(actual)
                .isNotNull();

        assertThat(actual.getTitle())
                .isEqualTo(expected.getTitle());

        assertThat(actual.getDescription())
                .isEqualTo(expected.getDescription());

        assertThat(actual.getBody())
                .isEqualTo(expected.getBody());
    }

    public static void assertSameArticle(ArticleResponse loadedArticle, ArticleResponse createdArticle) {
        assertThat(loadedArticle.getId())
                .isEqualTo(createdArticle.getId());
        assertThat(loadedArticle.getSlug())
                .isEqualTo(createdArticle.getSlug());
    }

}
