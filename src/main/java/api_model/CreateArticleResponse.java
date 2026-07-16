package api_model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateArticleResponse {

    private ArticleResponse article;

}
