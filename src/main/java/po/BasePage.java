package po;

import decorator.CustomFieldDecorator;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected final WebDriver driver;

    protected BasePage() {
        this.driver = BrowserFactory.getDriver();
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    protected abstract BasePage waitUntilOpened();
}
