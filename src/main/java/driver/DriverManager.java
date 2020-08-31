package driver;

import org.openqa.selenium.WebDriver;

import static logger.AllureLogger.logToAllureWarn;

public class DriverManager {

    private static WebDriver driver = null;

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = DriverFactory.buildDriver(DriverName.CHROME_DRIVER);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            logToAllureWarn("Driver quit");
            driver.quit();
            driver = null;
        }
    }
}
