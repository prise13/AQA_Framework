package api_model;

import java.util.Objects;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getDescData() {
        return descData;
    }

    public void setDescData(Object descData) {
        this.descData = descData;
    }

    public Object getEmoji() {
        return emoji;
    }

    public void setEmoji(Object emoji) {
        this.emoji = emoji;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getWebsite() {
        return website;
    }

    public void setWebsite(Object website) {
        this.website = website;
    }

    public Object getTeamType() {
        return teamType;
    }

    public void setTeamType(Object teamType) {
        this.teamType = teamType;
    }

    public Object getLogoHash() {
        return logoHash;
    }

    public void setLogoHash(Object logoHash) {
        this.logoHash = logoHash;
    }

    public Object getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(Object logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Object getProducts() {
        return products;
    }

    public void setProducts(Object products) {
        this.products = products;
    }

    public Object getPowerUps() {
        return powerUps;
    }

    public void setPowerUps(Object powerUps) {
        this.powerUps = powerUps;
    }

    public String getIdMemberCreator() {
        return idMemberCreator;
    }

    public void setIdMemberCreator(String idMemberCreator) {
        this.idMemberCreator = idMemberCreator;
    }

    public Object getLimits() {
        return limits;
    }

    public void setLimits(Object limits) {
        this.limits = limits;
    }

    @Override
    public String toString() {
        return "CreateOrganizationResponse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", descData=" + descData +
                ", emoji=" + emoji +
                ", url='" + url + '\'' +
                ", website=" + website +
                ", teamType=" + teamType +
                ", logoHash=" + logoHash +
                ", logoUrl=" + logoUrl +
                ", products=" + products +
                ", powerUps=" + powerUps +
                ", idMemberCreator='" + idMemberCreator + '\'' +
                ", limits=" + limits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateOrganizationResponse that = (CreateOrganizationResponse) o;
        return Objects.equals(name, that.name) && Objects.equals(displayName, that.displayName) && Objects.equals(desc, that.desc) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, displayName, desc, url);
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
