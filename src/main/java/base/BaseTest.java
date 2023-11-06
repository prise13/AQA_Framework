package base;

import bo.InstagramBO;
import factory.BrowserFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected InstagramBO instagramBO;

    @BeforeSuite
    public void beforeSuite() throws Exception {
        BrowserFactory.initDriver();
        BrowserFactory.setFullScreen();
        instagramBO = new InstagramBO(BrowserFactory.getDriver());
    }

    @AfterSuite
    public void afterSuite() {
        BrowserFactory.closeDriver();
    }

}
