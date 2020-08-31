package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static logger.AllureLogger.logToAllureWarn;
import static utils.PropertyFileHandler.*;

public class DriverFactory {

    static WebDriver buildDriver(final DriverName browserName) {
        WebDriver driver = null;
        if (browserName.equals(DriverName.CHROME_DRIVER)) {
            logToAllureWarn("Chrome driver is started");
            System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        } else if (browserName.equals(DriverName.GECKO_DRIVER)) {
            logToAllureWarn("Firefox(Gecko) driver is started");
            System.setProperty(GECKO_DRIVER, GECKO_DRIVER_PATH);
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
        return driver;
    }
}