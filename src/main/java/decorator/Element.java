package decorator;

import factory.BrowserFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tools.Environment;

import java.time.Duration;


public class Element {

    protected WebElement element;

    public Element(WebElement element) throws Exception {
        this.element = element;
    }

    public void waitForMe() throws Exception {
        int timeout = Integer.parseInt(Environment.getProperty("test.waitTimeout"));
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), Duration.ofSeconds(timeout));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (TimeoutException e) {
            Assert.fail("Visibility timeout");
        }
    }

}
