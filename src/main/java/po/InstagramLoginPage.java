//package po;
//
//import decorator.Button;
//import decorator.Input;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.FindBy;
//import org.testng.Assert;
//
//public class InstagramLoginPage extends BasePage{
//
//
//    //*[@id="loginForm"]/div/div[1]/div/label/input
//    @FindBy(xpath = "//*[@id=\"loginForm\"]/descendant::input[@name='username']")
//    private Input loginInput;
//
//    //*[@id="loginForm"]/div/div[2]/div/label/input
//    @FindBy(xpath = "//*[@id=\"loginForm\"]/descendant::input[@name='password']")
//    private Input passwordInput;
//
//    //*[@id="loginForm"]/div/div[3]/button
//    @FindBy(xpath = "//form[@id=\"loginForm\"]/descendant::button[@type='submit']")
//    private Button submitButton;
//
//    public InstagramLoginPage(WebDriver driver) {
//        super();
//    }
//
//    // Navigates to instagram's login page
//    public void openLoginPage() {
//        driver.get("https://www.instagram.com/?hl=ru");
//    }
//
//    // fills inputs with specified data and presses submit button
//    public void login(String login, String password) throws Exception {
//        submitButton.waitUntilVisible();
//        loginInput.fillWith(login);
//        passwordInput.fillWith(password);
//        if (submitButton.isActive()) {
//            submitButton.press();
//        }
//        else {
//            Assert.fail("Incorrect login data");
//        }
//    }
//
//
//
//}
