package driver;

import org.openqa.selenium.WebDriver;

import static logger.AllureLogger.logToAllureWarn;

public class DriverManager {

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            driverPool.set(new DriverFactory().buildDriver(DriverName.CHROME_DRIVER));
        }
        return driverPool.get();
    }

    public static void quitDriver() {
        if (driverPool.get() != null) {
            logToAllureWarn("Driver quit");
            driverPool.get().quit();
            driverPool.set(null);
        }
    }
}
