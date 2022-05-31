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

    @BeforeClass
    public void initAndLogin() {
        BrowserFactory.initDriver(BrowserFactory.Browsers.CHROME);
        this.instagramBO = new InstagramBO(BrowserFactory.getDriver());
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

    @AfterClass
    public void closeSession() {
        BrowserFactory.closeDriver();
    }

}
