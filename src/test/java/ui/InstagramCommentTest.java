package ui;

import base.BaseTest;
import bo.InstagramBO;
import factory.BrowserFactory;
import listener.AllureListener;
import org.testng.annotations.*;

@Listeners({AllureListener.class})
public class InstagramCommentTest extends BaseTest {

    private InstagramBO instagramBO;


    // implement Hibernate DP

    @DataProvider
    public Object[][] commentTestDP() {
        return new Object[][] {
                {"sami_sultanova", "Кльово!"},
                {"informationpersonal", "Вау!"}
        };
    }

    @BeforeClass
    public void init() throws Exception {
        this.instagramBO = new InstagramBO(BrowserFactory.getDriver());
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

    @AfterClass
    public void closeSession() {
        BrowserFactory.closeDriver();
    }
}
