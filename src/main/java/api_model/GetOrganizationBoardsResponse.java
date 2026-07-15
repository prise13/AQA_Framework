package api_model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetOrganizationBoardsResponse {
    private String id;
    private String name;
    private String desc;
    private String descData;
    private Boolean closed;
    private String idOrganization;
    private String idEnterprise;
    private Boolean pinned;
    private String starred;
    private String url;
    private String shortUrl;
    private Object prefs;
    private String shortLink;
    private Boolean subscribed;
    private Object limits;
    private Object labelNames;
    private Object powerUps;
    private Object dateClosed;
    private Object dateLastActivity;
    private String dateLastView;
    private Object idTags;
    private Object datePluginDisable;
    private Object creationMethod;
    private Object ixUpdate;
    private Object templateGallery;
    private Object enterpriseOwned;
    private Object idBoardSource;
    private Object premiumFeatures;
    private String idMemberCreator;
    private Object memberships;

}
