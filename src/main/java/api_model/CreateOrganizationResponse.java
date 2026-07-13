package api_model;

import lombok.Data;

import java.util.Objects;

@Data
public class CreateOrganizationResponse {

    private String id;
    private String name;
    private String displayName;
    private String desc;
    private Object descData;
    private Object emoji;
    private String url;
    private Object website;
    private Object teamType;
    private Object logoHash;
    private Object logoUrl;
    private Object products;
    private Object powerUps;
    private String idMemberCreator;
    private Object limits;
}
