package ui;

import bo.InstagramBO;
import factory.BrowserFactory;
import listener.AllureListener;
import org.testng.annotations.*;

@Listeners({AllureListener.class})
public class InstagramLikeTest {

    InstagramBO instagramBO;


    @DataProvider
    private Object[][] likeTestDP() {
        return new Object[][] {
                {"zelenskiy_official"},
                {"rterdogan"},
                {"_sh.mel_"},
                {"informationpersonal"}
        };
    }

    @BeforeTest
    public void initAndLogin() {
        BrowserFactory.initDriver("chrome");
        instagramBO = new InstagramBO();
        instagramBO
                .openLoginPage()
                .login("aqatest12", "AQAAuthenticationTest");

    }

    @Test(dataProvider = "likeTestDP")
    public void likeTest(String profileName) {
        instagramBO
                .searchForProfile(profileName)
                .clickOnFirstProfile()
                .clickOnFirstPost()
                .like()
                .verifyLike()
                .closePost();
    }

    @AfterTest
    public void closeSession() {
        BrowserFactory.getDriver().close();
        BrowserFactory.getDriver().quit();
    }

}
