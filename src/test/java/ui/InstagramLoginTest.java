package ui;

import bo.InstagramBO;
import factory.BrowserFactory;
import hibernate.HibernateService;
import listener.AllureListener;
import org.testng.annotations.*;

@Listeners({AllureListener.class})
public class InstagramLoginTest {


    @DataProvider
    public Object[][] instagramLoginDP() {
        return HibernateService.getLoginTestData();
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
