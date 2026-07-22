package po;

import decorator.Button;
import decorator.Element;
import org.openqa.selenium.support.FindBy;

public class MantisMyViewPage extends BasePage {

    @FindBy(id = "assigned")
    private Element assignedToMeBlock;

    @FindBy(css = "a[href='bug_report_page.php']")
    private Button reportIssueButton;

    public MantisReportIssuePage reportIssueFromHeader() {
        reportIssueButton.press();
        return new MantisReportIssuePage().waitUntilOpened();
    }

    @Override
    protected MantisMyViewPage waitUntilOpened() {
        assignedToMeBlock.waitUntilVisible();
        return this;
    }
}
