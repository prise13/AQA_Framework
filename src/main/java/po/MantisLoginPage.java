package po;


import constants.Routes;
import decorator.Button;
import decorator.Input;
import org.openqa.selenium.support.FindBy;

public class MantisLoginPage extends BasePage {

    @FindBy(id = "username")
    private Input usernameInput;

    @FindBy(xpath = "//input[@value='Login']")
    private Button loginButton;

    public MantisLoginPage open() {
        driver.get(Routes.LOGIN);
        waitUntilOpened();
        return this;
    }

    public MantisPasswordPage submitUsername(String username) {
        usernameInput.fillWith(username);
        loginButton.press();
        return new MantisPasswordPage();
    }

    public void waitUntilOpened() {
        usernameInput.waitUntilVisible();
    }

}
