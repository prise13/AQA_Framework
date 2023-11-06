package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import tools.Environment;

public class BrowserFactory {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (DRIVER.get() == null) {
            throw new RuntimeException("Driver wasn't initialized");
        }
        return DRIVER.get();
    }

//    public enum Browsers {
//        CHROME {
//            public String toString() {
//                return "chrome";
//            }
//        },
//        FIREFOX {
//            public String toString() {
//                return "firefox";
//            }
//        }
//    }


    public static void initDriver() throws Exception {
        String browser = Environment.getProperty("test.browser");
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                DRIVER.set(new ChromeDriver());
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                DRIVER.set(new FirefoxDriver());
            }
            default -> throw new RuntimeException("Wrong driver name, currently supported are 'chrome' and 'firefox' drivers!");
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
