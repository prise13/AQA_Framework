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

public class InstagramPostPage {
    WebDriver driver;

    WebElement likeButton;

    WebElement likeButtonPressed;

    WebElement closeButton;

    public InstagramPostPage() {
        driver = BrowserFactory.getDriver();
    }


    public void like() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            likeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.RnEpo._Yhr4 > div.pbNvD.QZZGH.bW6vo > div > article > div > div.HP0qD > div > div > div.eo2As > section.ltpMr.Slqrh > span.fr66n > button > div.QBdPU.rrUvL")));
        }
        catch (TimeoutException e) {
            Assert.fail("Failed to find like button");
        }
        likeButton.click();
    }

    public void verifyLike() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            likeButtonPressed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.RnEpo._Yhr4 > div.pbNvD.QZZGH.bW6vo > div > article > div > div.HP0qD > div > div > div.eo2As > section.ltpMr.Slqrh > span.fr66n > button > div")));
        }
        catch (TimeoutException e) {
            Assert.fail("Post is already liked");
        }
        Assert.assertTrue(likeButtonPressed.isDisplayed());
    }

    public void closePost() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
            closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.RnEpo._Yhr4 > div.NOTWr > button")));
        }
        catch (TimeoutException e) {
            Assert.fail("Failed to close post");
        }
        closeButton.click();
    }
}
