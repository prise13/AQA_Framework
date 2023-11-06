package bo;

import org.openqa.selenium.WebDriver;
import po.*;

public class InstagramBO {

    // Переробити

    private final InstagramLoginPage instagramLoginPage;
    private final InstagramMainPage instagramMainPage;
    private final InstagramProfilePage instagramProfilePage;
    private final InstagramPostPage instagramPostPage;
    private final InstagramMessagePage instagramMessagePage;
    private final WebDriver driver;
    private String profileName;

    public InstagramBO(WebDriver driver) {
        this.driver = driver;
        instagramLoginPage = new InstagramLoginPage(driver);
        instagramMainPage = new InstagramMainPage(driver);
        instagramProfilePage = new InstagramProfilePage(driver);
        instagramPostPage = new InstagramPostPage(driver);
        instagramMessagePage = new InstagramMessagePage(driver);
    }

    public InstagramBO openLoginPage() {
        instagramLoginPage.openLoginPage();
        return this;
    }
    public InstagramBO login(String login, String password) throws Exception {
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

    public InstagramBO prepareToTest() {
        instagramMainPage.clickOnLogo();
        instagramMainPage.declineNotifications();
        return this;
    }

    public InstagramBO clickOnFirstProfile() {
        instagramMainPage.clickOnProfile();
        return this;
    }
    public InstagramBO subscribe() {
        instagramProfilePage.subscribe(profileName);
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
    public InstagramBO leaveComment(String message) {
        instagramPostPage.leaveComment(message);
        return this;
    }
    public InstagramBO clickSendMessageButton() {
        instagramProfilePage.clickSendMessageButton();
        return this;
    }
    public InstagramBO sendMessage(String message) {
        instagramMessagePage.sendMessage(message);
        return this;
    }
    public InstagramBO declineNotifications() {
        instagramMessagePage.acceptShitModal();
        return this;
    }
}

