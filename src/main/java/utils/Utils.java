package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

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

}
