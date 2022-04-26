package decorator;

import org.openqa.selenium.WebElement;

public class Button extends Element{
    public Button(WebElement element) {
        super(element);
        this.element = element;
    }

    public void press() {
        element.click();
    }

    public boolean isActive() {
        return element.isEnabled();
    }

}
