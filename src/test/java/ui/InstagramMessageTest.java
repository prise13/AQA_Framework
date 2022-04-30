package ui;

import bo.InstagramBO;
import factory.BrowserFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InstagramMessageTest {
    private InstagramBO instagramBO;


    @DataProvider
    public Object[][] commentTestDP() {
        return new Object[][] {
                {"pushkin_ph", "Кльово!"},
                {"informationpersonal", "Вау!"}
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

    @Test
    public void messageTest() {
        instagramBO
                .searchForProfile("informationpersonal")
                .clickOnFirstProfile()
                .clickSendMessageButton()
                .declineNotifications()
                .sendMessage("Привіт!");
    }


    @AfterTest
    public void closeSession() {
//        BrowserFactory.getDriver().close();
//        BrowserFactory.getDriver().quit();
    }
}
