package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                DRIVER.set(new ChromeDriver(options));
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                DRIVER.set(new FirefoxDriver(options));
            }
            default -> throw new RuntimeException("Wrong driver name, currently supported are 'chrome' and 'edge' drivers!");
        }
    }

    public static void setFullScreen() {
        DRIVER.get().manage().window().maximize();
    }


    public static void closeDriver() {
        DRIVER.get().quit();
        DRIVER.remove();
    }
}
