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
import tools.Lang;

import java.time.Duration;

public class InstagramProfilePage {


    WebElement subscribeButton;

    WebElement subscribedButton;

    WebElement firstPost;

    WebElement sendMessageButton;

    private WebDriver driver;

    public InstagramProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new InstagramFieldDecorator(driver), this);
    }

    public void subscribe(String profileName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2"), profileName));
        }
        catch (TimeoutException e) {
            Assert.fail("Failed to load profile page");
        }
        try {
            subscribeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(div, \"%s\")]".formatted(Lang.SUBSCRIBE_RU))));
        }
        catch (TimeoutException e) {
            Assert.fail("You are already subscribed");
        }
        subscribeButton.click();
    }

    public void verifySubscription() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            subscribedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@aria-label, \"%s\")]".formatted(Lang.SUBSCRIBED_RU))));
        }
        catch (TimeoutException e) {
            Assert.fail("Subscription failed");
        }
        Assert.assertTrue(subscribedButton.isDisplayed());
    }

    public void clickOnFirstPost(String profileName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2"), profileName));
        }
        catch (TimeoutException e) {
            Assert.fail("Couldn't load profile page");
        }
        try {
            firstPost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_aagw")));
        }
        catch (TimeoutException e) {
            Assert.fail("Couldn't find first post");
        }
        firstPost.click();
    }

    public void clickSendMessageButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            sendMessageButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-root > section > main > div > header > section > div.XBGH5 > div.qF0y9.Igw0E.IwRSH.eGOV_.ybXk5._4EzTm.bPdm3 > div > div.qF0y9.Igw0E.IwRSH.eGOV_.acqo5.vwCYk.soMvl.i0EQd > button")));
        }
        catch (TimeoutException e) {
            Assert.fail("Couldn't press button");
        }
        sendMessageButton.click();
    }
}
