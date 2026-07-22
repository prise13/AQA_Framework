package uinew;

import base.BaseTest;
import enums.IssuePriority;
import org.testng.annotations.Test;

@Test
public class MantisReportIssueTest extends BaseTest {

    public void shouldCreateIssueWithValidParameters() {
        mantisBo.loginAsAdmin()
                .reportIssueFromHeader()
                .selectPriority(IssuePriority.URGENT);
    }

}
