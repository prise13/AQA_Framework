package ui;

import bo.InstagramBO;
import factory.BrowserFactory;
import listener.AllureListener;
import org.testng.annotations.*;

@Listeners({AllureListener.class})
public class InstagramMessageTest {
    private InstagramBO instagramBO;


    @BeforeClass
    public void init() {
        BrowserFactory.initDriver(BrowserFactory.Browsers.CHROME);
        instagramBO = new InstagramBO(BrowserFactory.getDriver());
        instagramBO
                .openLoginPage()
                .login("aqatest12", "AQAAuthenticationTest");
    }

    @Test
    public void messageTest() {
        instagramBO
                .searchForProfile("informationpersonal")
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
