package po;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class InstagramMessagePage {

    private final WebDriver driver;

    private WebElement messageInput;

    private WebElement sendButton;

    private WebElement acceptShitButton;

    public InstagramMessagePage() {
        driver = BrowserFactory.getDriver();
    }

    public void sendMessage(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            messageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-root > section > div > div.qF0y9.Igw0E.IwRSH.eGOV_.acqo5._4EzTm > div > div > div.DPiy6.qF0y9.Igw0E.IwRSH.eGOV_.acqo5.vwCYk > div.uueGX > div > div.qF0y9.Igw0E.IwRSH.eGOV_.acqo5._4EzTm > div > div > div.qF0y9.Igw0E.IwRSH.eGOV_.acqo5.vwCYk.ItkAi > textarea")));
        }
        catch (TimeoutException e) {
            Assert.fail("Couldnt load message page");
        }
        messageInput.click();
        messageInput = driver.findElement(By.cssSelector("#react-root > section > div > div.qF0y9.Igw0E.IwRSH.eGOV_.acqo5._4EzTm > div > div > div.DPiy6.qF0y9.Igw0E.IwRSH.eGOV_.acqo5.vwCYk > div.uueGX > div > div.qF0y9.Igw0E.IwRSH.eGOV_.acqo5._4EzTm > div > div > div.qF0y9.Igw0E.IwRSH.eGOV_.acqo5.vwCYk.ItkAi > textarea"));
        messageInput.sendKeys(message);
        try {
            sendButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-root > section > div > div.qF0y9.Igw0E.IwRSH.eGOV_.acqo5._4EzTm > div > div > div.DPiy6.qF0y9.Igw0E.IwRSH.eGOV_.acqo5.vwCYk > div.uueGX > div > div.qF0y9.Igw0E.IwRSH.eGOV_.acqo5._4EzTm > div > div > div.qF0y9.Igw0E.IwRSH.eGOV_.acqo5._4EzTm.JI_ht > button")));
        }
        catch (TimeoutException e) {
            Assert.fail("Couldn't send message");
        }
        sendButton.click();
    }

    public void acceptShitModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            acceptShitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.RnEpo.Yx5HN > div > div > div > div.mt3GC > button.aOOlW.HoLwm")));
        }
        catch (TimeoutException e) {
            System.out.println("clicked shit button");
        }
        acceptShitButton.click();
    }
}
