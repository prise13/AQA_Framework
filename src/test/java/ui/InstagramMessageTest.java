package ui;

import base.BaseTest;
import bo.InstagramBO;
import factory.BrowserFactory;
import listener.AllureListener;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.*;

@Listeners({AllureListener.class})
public class InstagramMessageTest extends BaseTest {
    private InstagramBO instagramBO;


    @DataProvider
    public Object[][] messageTestDP() {
        return new Object[][] {
                {"informationpersonal"},
                {"pushkin_ph"}
        };
    }

    @BeforeClass
    public void init() throws Exception {
        instagramBO = new InstagramBO(BrowserFactory.getDriver());
        instagramBO
                .openLoginPage()
                .login("aqatest12", "AQAAuthenticationTest");
    }

    @Test(dataProvider = "messageTestDP")
    public void messageTest(String profileName) {
        instagramBO
                .searchForProfile(profileName)
                .clickOnFirstProfile()
                .clickSendMessageButton()
                .declineNotifications()
                .sendMessage("Як справи?");
    }


    @AfterClass
    public void closeSession() {
        BrowserFactory.closeDriver();
    }
}
