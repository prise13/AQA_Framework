package po;

import decorator.Button;
import decorator.Input;
import decorator.InstagramFieldDecorator;
import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Time;
import java.time.Duration;
import java.util.List;

public class InstagramMainPage {

    private final WebDriver driver;

    public InstagramMainPage() {
        driver = BrowserFactory.getDriver();
        PageFactory.initElements(new InstagramFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[3]/div/div[6]")
    Button profileButton;

    @FindBy(css = "#react-root > section > nav > div._8MQSO.Cx7Bp > div > div > div.QY4Ed.P0xOK > input")
    Input searchInput;

    private String profileName;

    WebElement searchList;

    List<WebElement> profilesList;

    // verifies if transition to main page was successful
    public void verifyMainPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[3]/div/div[6]")));
        }
        catch (TimeoutException e) {
            Assert.fail("Failed to login");
        }
        Assert.assertTrue(profileButton.isActive());
    }

    // fills search input with specified profile name
    public void searchProfile(String profileName) {
        WebDriverWait searchInputWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement element = searchInputWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[2]/input")));
        }
        catch (TimeoutException e) {
            Assert.fail("Failed to load page");
        }
        searchInput.fillWith(profileName);
        WebDriverWait searchBlockWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            searchList = searchBlockWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#react-root > section > nav > div._8MQSO.Cx7Bp > div > div > div.QY4Ed.P0xOK > div.yPP5B > div > div._01UL2 > div")));
            this.profileName = profileName;
        }
        catch (TimeoutException e) {
            Assert.fail("Failed to load element");
        }
    }

    // clicks on first profile found
    public void clickOnProfile() {
        WebDriverWait clickerWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        try {
            profilesList = clickerWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(String.format("//a[contains(@href, '%s')]", profileName))));
        }
        catch (TimeoutException e) {
            e.printStackTrace();
        }

        if (profilesList != null && profilesList.size() > 0) {
            profilesList.get(0).click();
        }
        else {
            Assert.fail("Couldn't find profiles with that name");
        }
    }
}
