package base;

import bo.MantisBO;
import factory.BrowserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected MantisBO mantisBo;

    @BeforeMethod
    public void setUp() throws Exception {
        BrowserFactory.initDriver();
        mantisBo = new MantisBO();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        BrowserFactory.closeDriver();
    }

}
