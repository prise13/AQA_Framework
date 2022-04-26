package ui;

import bo.InstagramBO;
import factory.BrowserFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InstagramSubscribeTest {

    private InstagramBO instagramBO;



    @DataProvider
    private Object[][] subscribeDP() {
        return new Object[][] {
                {"zelenskiy_official"},
                {"link_huink"},
                {"rterdogan"}
        };
    }

    @BeforeTest
    public void init() {
        BrowserFactory.initDriver("chrome");
        instagramBO = new InstagramBO();
        instagramBO
                .openLoginPage()
                .login("aqatest13", "AQAAuthenticationTest");

    }

    @Test(dataProvider = "subscribeDP")
    public void subscribeTest(String profileName) {
        instagramBO
                .searchForProfile(profileName)
                .clickOnFirstProfile()
                .subscribe()
                .verifySubscription();
    }

    @AfterTest
    public void closeSession() {
//        BrowserFactory.getDriver().close();
//        BrowserFactory.getDriver().quit();
    }
}
