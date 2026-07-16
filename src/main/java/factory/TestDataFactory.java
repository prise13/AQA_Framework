package factory;

import api_model.ArticleRequest;
import api_model.CreateArticleRequest;

import java.util.Collections;

public final class TestDataFactory {

    private TestDataFactory() {}

    public static CreateArticleRequest createArticleRequest(String title, String description, String body) {
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
}