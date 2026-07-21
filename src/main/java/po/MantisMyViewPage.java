package po;

import decorator.Element;
import org.openqa.selenium.support.FindBy;

public class MantisMyViewPage extends BasePage {

    @FindBy(id = "assigned")
    private Element assignedToMeBlock;

    public void waitUntilOpened() {
        assignedToMeBlock.waitUntilVisible();
    }
}
