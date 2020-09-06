package testcase;

import driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static logger.AllureLogger.*;

public class CustomListeners implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment
    private byte[] saveScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    private static String saveTextLog(String message) {
        return message;
    }


    @Override
    public void onStart(ITestContext iTestContext) {
        logToAllureInfo("I am in onStart method " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logToAllureInfo("I am in onFinish method " + iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logToAllureInfo("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logToAllureInfo("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            logToAllureInfo("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            saveScreenShot(driver);
        }

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logToAllureError("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            logToAllureError("Error message: " + iTestResult.getThrowable().getMessage());
            logToAllureWarn("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            saveScreenShot(driver);
        }
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
    }


    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logToAllureWarn("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logToAllureWarn("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}
