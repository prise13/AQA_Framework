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

    @Test(dataProvider = "subscribeDP")
    public void subscribeTest(String profileName) {
        instagramBO
                .searchForProfile(profileName)
                .clickOnFirstProfile()
                .subscribe()
                .verifySubscription();
    }

    @AfterClass
    public void closeBrowser() {
        BrowserFactory.closeDriver();
    }
}
