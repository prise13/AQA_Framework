package factory;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// To do: Перевикористовувати
public class BrowserFactory {

    private static WebDriver instance;

    public static WebDriver getDriver() {
        if (instance == null) {
            throw new RuntimeException("Driver is not initializated, try calling initDriver function before getting driver!");
        }
        return instance;
    }


    public static void initDriver(String driverName) {
        switch (driverName) {
            case ("chrome") -> {
                ChromeDriverManager.getInstance().setup();
                instance = new ChromeDriver();
            }
            case ("firefox") -> {
                FirefoxDriverManager.getInstance().setup();
                instance = new FirefoxDriver();
            }
            default -> throw new RuntimeException("Wrong driver name, currently supported are 'chrome' and 'firefox' drivers!");
        }
    }
}
