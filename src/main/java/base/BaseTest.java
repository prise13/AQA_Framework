package base;

import factory.BrowserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    public void setUp() throws Exception {
        BrowserFactory.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        BrowserFactory.closeDriver();
    }

}
