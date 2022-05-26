package decorator;

import org.openqa.selenium.WebElement;


public class Input extends Element{

    public Input(WebElement element) {
        super(element);
        this.element = element;
    }

    // check if value is set after clearing
    public void fillWith(String value) {
        System.out.println("fill with " + value);
        element.clear();
        if (element.getAttribute("value").equals("")) {
        }
        else {
            element.clear();
        }
        element.sendKeys(value);
    }
}
