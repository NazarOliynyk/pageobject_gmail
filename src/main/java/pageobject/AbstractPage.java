package pageobject;

import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static logger.AllureLogger.logToAllureError;
import static logger.AllureLogger.logToAllureInfo;
import static logger.AllureLogger.logToAllureWarn;
import static utils.PropertyFileHandler.POLLING;
import static utils.PropertyFileHandler.FLUENT_WAIT_TIMEOUT;

public abstract class AbstractPage {

    AbstractPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
        logToAllureInfo("Initialize PageFactory in: " + this.getClass().getName());
    }

    private static FluentWait<WebDriver> newWait() {
        return new FluentWait<>(DriverFactory.getDriver())
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
    }

    public void goToPageURL(final String url) {
        DriverFactory.getDriver().get(url);
        logToAllureInfo("Going to URL: " + url);
    }

    WebElement getElementWithWait(WebElement element) {
        logToAllureInfo("Waiting for element: ( " + getLocatorFromElement(element) + " )");
        return newWait().until(ExpectedConditions.visibilityOf(element));
    }

    WebElement getElementWithWaitAndPolling(WebElement element) {
        logToAllureInfo("Waiting with polling for element: ( " + getLocatorFromElement(element) + " )");
        return newWait()
                .withTimeout(Duration.ofSeconds(FLUENT_WAIT_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(POLLING))
                .until(ExpectedConditions.visibilityOf(element));
    }

    boolean isDisplayed(WebElement element) {
        try {
            logToAllureInfo("Checking if element: ( " + getLocatorFromElement(element) + " ) is displayed");
            return element.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            logToAllureWarn("Element: ( " + getLocatorFromElement(element) + " ) is NOT displayed");
            return false;
        }
    }

    private String getLocatorFromElement(WebElement element) {
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
