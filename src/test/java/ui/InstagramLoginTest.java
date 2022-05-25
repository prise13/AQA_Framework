package ui;

import bo.InstagramBO;
import factory.BrowserFactory;
import listener.AllureListener;
import org.testng.annotations.*;

@Listeners({AllureListener.class})
public class InstagramLoginTest {


    @DataProvider
    public Object[][] instagramLoginDP() {
        return new Object[][] {
                {"123123","user21312"},
                {"123123123","213123123123"},
                {"aqatest12", "AQAAuthenticationTest"}
        };
    }


    @BeforeTest
    public void init() {
        BrowserFactory.initDriver("chrome");
    }


    @Test(dataProvider = "instagramLoginDP")
    public void loginTest(String login, String password) {
        InstagramBO instagramBO = new InstagramBO();
        instagramBO
                .openLoginPage()
                .login(login, password)
                .verifyMainPage();
    }


    @AfterTest
    public void closeSession() {
        BrowserFactory.getDriver().close();
        BrowserFactory.getDriver().quit();
    }
}
