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

import java.time.Duration;

public class InstagramLoginPage extends BasePage{


    //*[@id="loginForm"]/div/div[1]/div/label/input
    @FindBy(xpath = "//*[@id=\"loginForm\"]/descendant::input[@name='username']")
    private Input loginInput;

    //*[@id="loginForm"]/div/div[2]/div/label/input
    @FindBy(xpath = "//*[@id=\"loginForm\"]/descendant::input[@name='password']")
    private Input passwordInput;

    //*[@id="loginForm"]/div/div[3]/button
    @FindBy(xpath = "//form[@id=\"loginForm\"]/descendant::button[@type='submit']")
    private Button submitButton;

    public InstagramLoginPage(WebDriver driver) {
        super(driver);
    }

    // Navigates to instagram's login page
    public void openLoginPage() {
        driver.get("https://www.instagram.com/?hl=ru");
    }

    // fills inputs with specified data and presses submit button
    public void login(String login, String password) throws Exception {
        submitButton.waitForMe();
        loginInput.fillWith(login);
        passwordInput.fillWith(password);
        if (submitButton.isActive()) {
            submitButton.press();
        }
        else {
            Assert.fail("Incorrect login data");
        }
    }



}
