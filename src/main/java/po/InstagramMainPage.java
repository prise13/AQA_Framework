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
import tools.Lang;

import java.sql.Time;
import java.time.Duration;
import java.util.List;

public class InstagramMainPage extends BasePage {

    public InstagramMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[3]/div/div[6]")
    Button profileButton;


    @FindBy(xpath = "//input[contains(@aria-label, \"Ввод поискового запроса\")]")
    Input searchInput;

    private String profileName;

    WebElement searchList;

    List<WebElement> profilesList;

    WebElement logo;

    WebElement declineButton;

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

    public void clickOnLogo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        try {
                this.logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[1]/a")));
        }
        catch (TimeoutException e) {
            Assert.fail("Failed to click on logo");
        }
        logo.click();
    }

    public void declineNotifications() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            this.declineButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button._a9--._a9_1")));
        }
        catch (TimeoutException e) {
            System.out.println("Notifications are already declined");
        }
        declineButton.click();
    }

    // fills search input with specified profile name
    public void searchProfile(String profileName) {
        WebDriverWait searchInputWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement element = searchInputWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@aria-label, \"%s\")]".formatted(Lang.SEARCH_RU))));
        }
        catch (TimeoutException e) {
            Assert.fail("Failed to load page");
        }
        searchInput.fillWith(profileName);
        WebDriverWait searchBlockWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            // searchList = searchBlockWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_abnx")));
            searchList = searchBlockWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@role, \"none\")]/..")));
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
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            try {
                wait.until(ExpectedConditions.elementToBeClickable(profilesList.get(0)));
            }
            catch (TimeoutException e) {
                System.out.println("Couldn't click on profile");
            }
            profilesList.get(0).click();
        }
        else {
            Assert.fail("Couldn't find profiles with that name");
        }
    }
}
