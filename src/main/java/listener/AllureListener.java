package listener;

import factory.BrowserFactory;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class AllureListener implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("test failed");
        takeScreenshot();
    }

    private void takeScreenshot() {
        Allure.addAttachment("Page screenshot", new ByteArrayInputStream(((TakesScreenshot) BrowserFactory.getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
