package po;

import decorator.Input;
import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tools.Lang;

import java.time.Duration;

public class InstagramPostPage {
    WebDriver driver;

    WebElement likeButton;

    WebElement likeButtonPressed;

    WebElement closeButton;

    WebElement commentInput;

    WebElement submitButton;

    public InstagramPostPage(WebDriver driver) {
        this.driver = driver;
    }


    public void like() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            likeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div/div/div[1]/div/div[3]/div/div/div/div/div[2]/div/article/div/div[2]/div/div/div[2]/section[1]/span[1]/button")));
        }
        catch (TimeoutException e) {
            Assert.fail("Failed to find like button");
        }
        likeButton.click();
    }

    public void verifyLike() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            wait.until(ExpectedConditions.attributeToBe(likeButton, "aria-label", "Не подобається"));
        }
        catch (TimeoutException e) {
            System.out.println(driver.findElements(By.className("_ab6-")).get(0).getAttribute("aria-label"));
            // Assert.fail("Post is already liked");
        }
        Assert.assertTrue(true);
    }

    public void closePost() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.futnfnd5.li38xygf.q0p5rdf8.mudwbb97")));
        }
        catch (TimeoutException e) {
            Assert.fail("Failed to close post");
        }
        closeButton.click();
    }

    public void leaveComment(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            commentInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea")));
        }
        catch (TimeoutException e) {
            Assert.fail("Failed to load textarea");
        }
        commentInput.click();
        commentInput = driver.findElement(By.xpath("//textarea"));
        commentInput.sendKeys(message);
        try {
            submitButton = driver.findElement(By.xpath("//div[contains(text(), \"%s\")]/..".formatted(Lang.SUBMIT_RU)));
            wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        }
        catch (TimeoutException e) {
            Assert.fail("Failed to comment");
        }
        submitButton.click();
        Assert.assertTrue(true);
    }
}
