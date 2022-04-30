package bo;

import po.InstagramLoginPage;
import po.InstagramMainPage;
import po.InstagramPostPage;
import po.InstagramProfilePage;

public class InstagramBO {

    private final InstagramLoginPage instagramLoginPage;
    private final InstagramMainPage instagramMainPage;
    private final InstagramProfilePage instagramProfilePage;
    private final InstagramPostPage instagramPostPage;
    private String profileName;

    public InstagramBO() {
        instagramLoginPage = new InstagramLoginPage();
        instagramMainPage = new InstagramMainPage();
        instagramProfilePage = new InstagramProfilePage();
        instagramPostPage = new InstagramPostPage();

    }

    public InstagramBO openLoginPage() {
        instagramLoginPage.openLoginPage();
        return this;
    }
    public InstagramBO login(String login, String password) {
        instagramLoginPage.login(login, password);
        return this;
    }
    public InstagramBO verifyMainPage() {
        instagramMainPage.verifyMainPage();
        return this;
    }
    public InstagramBO searchForProfile(String profileName) {
        instagramMainPage.searchProfile(profileName);
        this.profileName = profileName;
        return this;
    }
    public InstagramBO clickOnFirstProfile() {
        instagramMainPage.clickOnProfile();
        return this;
    }
    public InstagramBO subscribe() {
        instagramProfilePage.subscribe();
        return this;
    }
    public InstagramBO verifySubscription() {
        instagramProfilePage.verifySubscription();
        return this;
    }
    public InstagramBO clickOnFirstPost() {
        instagramProfilePage.clickOnFirstPost(this.profileName);
        return this;
    }
    public InstagramBO like() {
        instagramPostPage.like();
        return this;
    }
    public InstagramBO verifyLike() {
        instagramPostPage.verifyLike();
        return this;
    }
    public InstagramBO closePost() {
        instagramPostPage.closePost();
        return this;
    }
}

