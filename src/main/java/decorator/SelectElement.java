package decorator;

import enums.IssuePriority;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectElement extends Element {

    public SelectElement(WebElement element) {
        super(element);
    }

    public void selectByValue(IssuePriority priority) {
        new Select(element).selectByValue(priority.getValue());
    }

    public void selectByText(IssuePriority priority) {
        new Select(element).selectByVisibleText(priority.getValue());
    }

}
