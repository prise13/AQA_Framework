package po;

import decorator.InstagramFieldDecorator;
import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class InstagramProfilePage {


    WebElement subscribeButton;

    WebElement subscribedButton;

    private WebDriver driver = BrowserFactory.getDriver();

    public InstagramProfilePage() {
        PageFactory.initElements(new InstagramFieldDecorator(driver), this);
    }

    public void subscribe() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            subscribeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button._5f5mN.jIbKX._6VtSN.yZn4P")));
        }
        catch (TimeoutException e) {
            Assert.fail("You are already subscribed");
        }
        subscribeButton.click();
    }

    public void verifySubscription() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            subscribedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button._5f5mN.-fzfL._6VtSN.yZn4P")));
        }
        catch (TimeoutException e) {
            Assert.fail("Subscription failed");
        }
        Assert.assertTrue(subscribedButton.isDisplayed());
    }
}
