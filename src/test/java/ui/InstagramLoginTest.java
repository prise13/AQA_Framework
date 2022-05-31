package ui;

import bo.InstagramBO;
import factory.BrowserFactory;
import hibernate.HibernateService;
import listener.AllureListener;
import org.testng.annotations.*;

@Listeners({AllureListener.class})
public class InstagramLoginTest {

    private InstagramBO instagramBO;


    @DataProvider
    public Object[][] instagramLoginDP() {
        return HibernateService.getLoginTestData();
    }


    @BeforeClass
    public void initDriver() {
        BrowserFactory.initDriver(BrowserFactory.Browsers.CHROME);
        this.instagramBO = new InstagramBO(BrowserFactory.getDriver());
    }


    @Test(dataProvider = "instagramLoginDP")
    public void loginTest(String login, String password) {
        instagramBO
                .openLoginPage()
                .login(login, password)
                .verifyMainPage();
    }

    @AfterClass
    public void closeBrowser() {
        BrowserFactory.closeDriver();
    }
}
