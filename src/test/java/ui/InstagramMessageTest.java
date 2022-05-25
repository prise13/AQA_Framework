package ui;

import bo.InstagramBO;
import factory.BrowserFactory;
import listener.AllureListener;
import org.testng.annotations.*;

@Listeners({AllureListener.class})
public class InstagramMessageTest {
    private InstagramBO instagramBO;


//    @DataProvider
//    public Object[][] messageTestDP() {
//        return new Object[][] {
//                {"_stvorena_z_tsukru_", "Тест 7000"},
//                {"informationpersonal", "Вау!"}
//        };
//    }

    @BeforeTest
    public void init() {
        BrowserFactory.initDriver("chrome");
        instagramBO = new InstagramBO();
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


    @AfterTest
    public void closeSession() {
//        BrowserFactory.getDriver().close();
//        BrowserFactory.getDriver().quit();
    }
}
