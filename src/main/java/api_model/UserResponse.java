package api_model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private String email;

    private String username;

    private String bio;

    private String image;

    private String token;

}