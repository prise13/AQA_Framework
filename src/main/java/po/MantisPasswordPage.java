package po;

import constants.Routes;
import decorator.Button;
import decorator.Input;
import org.openqa.selenium.support.FindBy;

public class MantisPasswordPage extends BasePage {

    @FindBy(id = "password")
    private Input passwordInput;

    @FindBy(xpath = "//input[@value='Login']")
    private Button loginButton;

    public MantisMyViewPage submitPassword(String password) {
        waitUntilOpened();
        passwordInput.fillWith(password);
        loginButton.press();
        return new MantisMyViewPage();
    }

    public MantisPasswordPage waitUntilOpened() {
        passwordInput.waitUntilVisible();
        return this;
    }
}
