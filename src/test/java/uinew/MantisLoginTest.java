package uinew;

import base.BaseTest;
import org.testng.annotations.Test;
import po.MantisLoginPage;

public class MantisLoginTest extends BaseTest {

    @Test
    public void loginTest() {
        new MantisLoginPage()
                .open()
                .submitUsername("administrator")
                .submitPassword("root123")
                .waitUntilOpened();
    }
}
