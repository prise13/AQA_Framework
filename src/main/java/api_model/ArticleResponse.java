package api_model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleResponse {

    private String id;

    private String slug;

    private String title;

    private String description;

    private String body;

    private boolean favorited;

    private int favoritesCount;

    private String createdAt;

    private String updatedAt;

    private List<Tags> tagList;

    private Cursor cursor;

    private Author author;

}
