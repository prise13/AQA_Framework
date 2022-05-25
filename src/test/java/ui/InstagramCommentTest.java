package ui;

import bo.InstagramBO;
import factory.BrowserFactory;
import listener.AllureListener;
import org.testng.annotations.*;

@Listeners({AllureListener.class})
public class InstagramCommentTest {

    private InstagramBO instagramBO;


    @DataProvider
    public Object[][] commentTestDP() {
        return new Object[][] {
                {"sami_sultanova", "Кльово!"},
                {"informationpersonal", "Вау!"}
        };
    }

    @BeforeTest
    public void init() {
        BrowserFactory.initDriver("chrome");
        instagramBO = new InstagramBO();
        instagramBO
                .openLoginPage()
                .login("aqatest12", "AQAAuthenticationTest");
    }

    @Test(dataProvider = "commentTestDP")
    public void commentTest(String profileName, String message) {
        instagramBO
                .searchForProfile(profileName)
                .clickOnFirstProfile()
                .clickOnFirstPost()
                .leaveComment(message)
                .closePost();
    }

    @AfterTest
    public void closeSession() {
        BrowserFactory.getDriver().close();
        BrowserFactory.getDriver().quit();
    }
}
