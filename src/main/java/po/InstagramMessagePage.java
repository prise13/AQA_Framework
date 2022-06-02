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

    public InstagramMessagePage(WebDriver driver) {
        this.driver = driver;
    }

    public void sendMessage(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            messageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[contains(@placeholder, \"Напишите сообщение\")]")));
        }
        catch (TimeoutException e) {
            Assert.fail("Couldnt load message page");
        }
        messageInput.click();
        messageInput = driver.findElement(By.xpath("//textarea[contains(@placeholder, \"Напишите сообщение\")]"));
        messageInput.sendKeys(message);
        try {
            sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), \"Отправить\")]")));
        }
        catch (TimeoutException e) {
            Assert.fail("Couldn't send message");
        }
        sendButton.click();
    }

    public void acceptShitModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            acceptShitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), \"Не сейчас\")]")));
        }
        catch (TimeoutException e) {
            System.out.println("Skipped modal");
        }
        try {
            acceptShitButton.click();
        }
        catch (Exception e) {
            System.out.println("Modal didn't appear");
        }
    }
}
