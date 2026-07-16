package api_model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    private String username;

    private String bio;

    private String image;

    private boolean following;

}
