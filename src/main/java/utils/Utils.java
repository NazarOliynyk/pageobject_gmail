package utils;

import driver.DriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import userdata.User;
import userdata.UserDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static logger.AllureLogger.*;

public class Utils {

    public static FluentWait<WebDriver> newWait() {
        return new FluentWait<>(DriverManager.getDriver())
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
    }

    public static void waitUntilDocumentReadyState() {
        logToAllureInfo("Waiting for the ready state of document ");
        newWait().until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) Objects.requireNonNull(wd))
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    public static List<User> initializeUserData() {
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
