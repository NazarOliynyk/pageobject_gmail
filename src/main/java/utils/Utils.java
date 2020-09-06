package utils;

import driver.DriverManager;
import org.openqa.selenium.*;
import userdata.User;
import userdata.UserDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static logger.AllureLogger.*;

public class Utils {

    public static void goToPageURL(final String url) {
        logToAllureInfo("Going to URL: " + url);
        DriverManager.getDriver().get(url);
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

    public static List<User> initializeUserData() {
        List<User> userList = new ArrayList<>();
        try {
            logToAllureWarn("Extracting users data ");
            userList = new UserDAO().getAll();
        } catch (IOException e) {
            logToAllureError(e.getMessage());
        }
        return userList;
    }
}