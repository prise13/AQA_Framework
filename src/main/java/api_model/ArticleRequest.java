package api_model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleRequest {

    private String title;

    private String description;

    private String body;

    private List<Tags> tagList;

}
