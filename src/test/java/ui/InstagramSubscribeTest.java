package ui;

import bo.InstagramBO;
import factory.BrowserFactory;
import listener.AllureListener;
import org.testng.annotations.*;

@Listeners({AllureListener.class})
public class InstagramSubscribeTest {

    private InstagramBO instagramBO;



    @DataProvider
    private Object[][] subscribeDP() {
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
        BrowserFactory.getDriver().close();
        BrowserFactory.getDriver().quit();
    }
}
