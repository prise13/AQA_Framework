package ui;

import base.BaseTest;
import bo.InstagramBO;
import factory.BrowserFactory;
import hibernate.HibernateService;
import listener.AllureListener;
import org.testng.annotations.*;

@Listeners({AllureListener.class})
public class InstagramLoginTest extends BaseTest {

//    @DataProvider
//    public Object[][] instagramLoginDP() {
//        return HibernateService.getLoginTestData();
//    }

    @Test()
    public void loginTest() throws Exception {
        instagramBO
                .openLoginPage()
                .login("aqatest12", "123")
                .verifyMainPage();
    }
}
