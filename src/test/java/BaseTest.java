import driver.DriverFactory;
import driver.DriverManager;
import driver.DriverName;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import userdata.User;
import userdata.UserDAO;

import java.io.IOException;

import static logger.AllureLogger.*;

@Listeners({CustomListeners.class})
public abstract class BaseTest {

    User user = null;

    @BeforeMethod
    public void beforeMethod() {
        try {
            logToAllureWarn("User data extracted successfully");
            user = new UserDAO().getAll().get(0);
        } catch (IOException | ParseException e) {
            logToAllureError(e.getMessage());
        }
    }

    @AfterMethod
    public void afterMethod() {
        DriverManager.quitDriver();
    }
}