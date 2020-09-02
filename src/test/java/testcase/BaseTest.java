package testcase;

import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import userdata.User;
import utils.CustomListeners;
import utils.TestUtils;

import static utils.Utils.initializeUserData;

@Listeners({CustomListeners.class})
public abstract class BaseTest {

    User user = null;

    @BeforeMethod
    public void beforeMethod() {
        user = initializeUserData().get(0);
        TestUtils.sendDefaultLetter(user);
    }

    @AfterMethod
    public void afterMethod() {
        TestUtils.deleteDefaultLetter();
        DriverManager.quitDriver();
    }
}