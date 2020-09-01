package utils;

import businessobject.LoginationBO;
import businessobject.SendingLettersBO;
import driver.DriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import pageobject.HomePage;
import pageobject.SentLettersPage;
import userdata.User;
import userdata.UserDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static logger.AllureLogger.logToAllureError;
import static logger.AllureLogger.logToAllureInfo;
import static logger.AllureLogger.logToAllureWarn;
import static utils.PropertyFileHandler.*;

public class Utils {

    public static boolean isDisplayed(WebElement element) {
        try {
            logToAllureInfo("Checking if element: ( " + getLocatorFromElement(element) + " ) is displayed");
            return element.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            logToAllureWarn("Element: ( " + getLocatorFromElement(element) + " ) is NOT displayed");
            return false;
        }
    }

    public static String getLocatorFromElement(WebElement element) {
        try {
            return element.toString()
                    .split("->")[1]
                    .replaceFirst("(?s)(.*)]", "$1" + "");
        } catch (ArrayIndexOutOfBoundsException e) {
            logToAllureError(String.valueOf(e.getCause()));
            return "parsing of locator from element failed !!";
        }
    }

    public static List<User> initializeUserData(){
        List<User> userList = new ArrayList<>();
        try {
            logToAllureWarn("User data extracted successfully");
            userList = new UserDAO().getAll();
        } catch (IOException | ParseException e) {
            logToAllureError(e.getMessage());
        }
        return userList;
    }

    public static void sendDefaultLetter(User user){
        logToAllureWarn("Sending Default letter to fill the list of letters");
        LoginationBO loginationBO = new LoginationBO();
        loginationBO.logIn(user);
        SendingLettersBO sendingLettersBO = new SendingLettersBO();
        sendingLettersBO.sendNewLetter(RECIPIENT_EMAIL, DEFAULT_SUBJECT, DEFAULT_CONTENT);
        DriverManager.quitDriver();
        logToAllureInfo("Default letter has been sent, User log out ");
    }

}
