package utils;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import userdata.User;
import userdata.UserDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static logger.AllureLogger.logToAllureError;
import static logger.AllureLogger.logToAllureInfo;
import static logger.AllureLogger.logToAllureWarn;

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
            logToAllureWarn("Extracting users data ");
            userList = new UserDAO().getAll();
        } catch (IOException | ParseException e) {
            logToAllureError(e.getMessage());
        }
        return userList;
    }
}
