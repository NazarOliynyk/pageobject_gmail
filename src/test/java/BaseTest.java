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
import static utils.Utils.initializeUserData;
import static utils.Utils.sendDefaultLetter;

@Listeners({CustomListeners.class})
public abstract class BaseTest {

    User user = null;

    @BeforeMethod
    public void beforeMethod() {
        user = initializeUserData().get(0);
//        sendDefaultLetter(user);
    }

    @AfterMethod
    public void afterMethod() {
        DriverManager.quitDriver();
    }
}