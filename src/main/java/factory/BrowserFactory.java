package factory;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (DRIVER.get() == null) {
            throw new RuntimeException("Driver wasn't initialized");
        }
        return DRIVER.get();
    }

    public enum Browsers {
        CHROME {
            public String toString() {
                return "chrome";
            }
        },
        FIREFOX {
            public String toString() {
                return "firefox";
            }
        }
    }


    public static void initDriver(Browsers browsers) {
        switch (browsers) {
            case CHROME -> {
                ChromeDriverManager.getInstance().setup();
                DRIVER.set(new ChromeDriver());
            }
            case FIREFOX -> {
                FirefoxDriverManager.getInstance().setup();
                DRIVER.set(new FirefoxDriver());
            }
            default -> throw new RuntimeException("Wrong driver name, currently supported are 'chrome' and 'edge' drivers!");
        }
    }


    public static void closeDriver() {
        DRIVER.get().quit();
        DRIVER.remove();
    }
}
