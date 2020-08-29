import driver.DriverFactory;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import userdata.User;
import userdata.UserDAO;

import java.io.IOException;

import static utils.PropertyFileHandler.CHROME_DRIVER;
import static logger.AllureLogger.*;

@Listeners({CustomListeners.class})
public abstract class BaseTest {

    User user = null;
    @BeforeMethod
    public void beforeMethod() {
        DriverFactory.buildDriver(CHROME_DRIVER);
        try {
            user = new UserDAO().getAll().get(0);
            logToAllureWarn("User data extracted successfully");
        } catch (IOException | ParseException e) {
            logToAllureError(e.getMessage());
        }
    }

    @AfterMethod
    public void afterMethod() {
        DriverFactory.quitDriver();
    }
}