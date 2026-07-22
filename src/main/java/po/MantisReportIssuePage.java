package po;

import decorator.SelectElement;
import enums.IssuePriority;
import org.openqa.selenium.support.FindBy;

public class MantisReportIssuePage extends BasePage {

    @FindBy(id = "priority")
    private SelectElement prioritySelect;


    public MantisReportIssuePage selectPriority(IssuePriority priority) {
        prioritySelect.selectByText(priority);
        return this;
    }

    @Override
    protected MantisReportIssuePage waitUntilOpened() {
        prioritySelect.waitUntilVisible();
        return this;
    }

}
