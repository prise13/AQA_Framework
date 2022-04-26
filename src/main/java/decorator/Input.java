package decorator;

import org.openqa.selenium.WebElement;

public class Input extends Element{

    public Input(WebElement element) {
        super(element);
        this.element = element;
    }

    public void fillWith(String value) {
        element.clear();
        element.sendKeys(value);
    }
}
