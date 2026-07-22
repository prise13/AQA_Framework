package uinew;

import base.BaseTest;
import org.testng.annotations.Test;

public class MantisLoginTest extends BaseTest {

    @Test
    public void shouldLoginWithAdminCredentials() {
        mantisBo.loginAsAdmin();
    }
}
