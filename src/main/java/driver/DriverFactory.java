package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static logger.AllureLogger.logToAllureWarn;
import static utils.PropertyFileHandler.CHROME_DRIVER;
import static utils.PropertyFileHandler.CHROME_DRIVER_PATH;
import static utils.PropertyFileHandler.GECKO_DRIVER;
import static utils.PropertyFileHandler.GECKO_DRIVER_PATH;

public class DriverFactory {

    private static WebDriver driver;

    public static void buildDriver(final String browserName) {

        if (browserName.equalsIgnoreCase(CHROME_DRIVER)) {
            System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
            logToAllureWarn("Chrome driver is started");
        } else if (browserName.equalsIgnoreCase(GECKO_DRIVER)) {
            System.setProperty(GECKO_DRIVER, GECKO_DRIVER_PATH);
            driver = new FirefoxDriver();
            logToAllureWarn("Firefox(Gecko) driver is started");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            logToAllureWarn("Driver quit");
        }
    }
}