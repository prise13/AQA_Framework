package factory;

import api_model.ArticleRequest;
import api_model.CreateArticleRequest;

import java.util.Collections;
import java.util.UUID;

public final class TestDataFactory {

    private TestDataFactory() {}

    public static CreateArticleRequest createDefaultArticleRequest() {
        String title = UUID.randomUUID()+ "_title";
        String description = UUID.randomUUID()+ "_description";
        String body = UUID.randomUUID() + "_body";
        return CreateArticleRequest.builder()
                .article(
                        ArticleRequest.builder()
                                .title(title)
                                .description(description)
                                .body(body)
                                .tagList(Collections.emptyList())
                                .build())
                .build();
    }

    public static CreateArticleRequest createArticleWithoutTitleRequest() {
        String description = UUID.randomUUID()+ "_description";
        String body = UUID.randomUUID() + "_body";
        return CreateArticleRequest.builder()
                .article(
                        ArticleRequest.builder()
                                .description(description)
                                .body(body)
                                .tagList(Collections.emptyList())
                                .build())
                .build();
    }
}