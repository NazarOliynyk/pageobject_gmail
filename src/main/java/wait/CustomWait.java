package wait;

import driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Objects;

import static logger.AllureLogger.logToAllureInfo;
import static utils.PropertyFileHandler.FLUENT_WAIT_TIMEOUT;
import static utils.PropertyFileHandler.POLLING;
import static utils.Utils.getLocatorFromElement;

public class CustomWait {

    public static FluentWait<WebDriver> getNewFluentWait() {
        return new FluentWait<>(DriverManager.getDriver())
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
    }

    public static void waitUntilDocumentReadyState() {
        logToAllureInfo("Waiting for the ready state of document ");
        getNewFluentWait()
                .withTimeout(Duration.ofSeconds(FLUENT_WAIT_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(POLLING))
                .until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) Objects.requireNonNull(wd))
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    public static WebElement waitWithPollingUntilVisibilityAndGetElement(WebElement element) {
        return getNewFluentWait()
                .withTimeout(Duration.ofSeconds(FLUENT_WAIT_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(POLLING))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitUntilVisibilityAndGetElement(WebElement element) {
        logToAllureInfo("Waiting for the plain WebElement: ( " + getLocatorFromElement(element) + " )");
        return getNewFluentWait().until(ExpectedConditions.visibilityOf(element));
    }

}
