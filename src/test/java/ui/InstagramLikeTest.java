package ui;

import base.BaseTest;
import bo.InstagramBO;
import factory.BrowserFactory;
import listener.AllureListener;
import org.testng.annotations.*;

@Listeners({AllureListener.class})
public class InstagramLikeTest extends BaseTest {

    InstagramBO instagramBO;


    @DataProvider
    private Object[][] likeTestDP() {
        return new Object[][] {
                {"zelenskiy_official"},
                {"_sh.mel_"},
                {"informationpersonal"}
        };
    }

    @BeforeClass
    public void initAndLogin() throws Exception {
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
                .closePost();
    }

    @AfterClass
    public void closeSession() {
        BrowserFactory.closeDriver();
    }

}
