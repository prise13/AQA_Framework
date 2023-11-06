package decorator;

import factory.BrowserFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tools.Environment;

import java.time.Duration;

public class Button extends Element {

    public Button(WebElement element) throws Exception {
        super(element);
        this.element = element;
    }

    public void press() {
        element.click();
    }

    public boolean isActive() {
        return element.isEnabled();
    }


}
