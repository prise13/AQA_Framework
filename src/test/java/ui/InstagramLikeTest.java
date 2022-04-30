package ui;

import bo.InstagramBO;
import factory.BrowserFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InstagramLikeTest {

    InstagramBO instagramBO;


    @DataProvider
    private Object[][] likeTestDP() {
        return new Object[][] {
                {"zelenskiy_official"},
                {"link_huink"},
                {"rterdogan"},
                {"pushkin_ph"}
        };
    }

    @BeforeTest
    public void initAndLogin() {
        BrowserFactory.initDriver("chrome");
        instagramBO = new InstagramBO();
        instagramBO
                .openLoginPage()
                .login("aqatest13", "AQAAuthenticationTest");

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
//        BrowserFactory.getDriver().close();
//        BrowserFactory.getDriver().quit();
    }

}
