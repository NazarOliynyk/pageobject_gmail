package pageobject;

import driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Objects;

import static logger.AllureLogger.logToAllureInfo;
import static utils.PropertyFileHandler.POLLING;
import static utils.PropertyFileHandler.FLUENT_WAIT_TIMEOUT;
import static utils.Utils.getLocatorFromElement;

public abstract class AbstractPage {

    AbstractPage() {
        logToAllureInfo("Initialize PageFactory in: " + this.getClass().getName());
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    private static FluentWait<WebDriver> newWait() {
        return new FluentWait<>(DriverManager.getDriver())
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
    }

    public void goToPageURL(final String url) {
        logToAllureInfo("Going to URL: " + url);
        DriverManager.getDriver().get(url);
    }

    WebElement waitUntilVisibilityAndGetElement(WebElement element) {
        logToAllureInfo("Waiting for element: ( " + getLocatorFromElement(element) + " )");
        return newWait().until(ExpectedConditions.visibilityOf(element));
    }

   public void waitUntilDocumentReadyState() {
        logToAllureInfo("Waiting for the ready state of document ");
         newWait().until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) Objects.requireNonNull(wd))
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    WebElement waitWithPollingUntilVisibilityAndGetElement(WebElement element) {
        logToAllureInfo("Waiting with polling for element: ( " + getLocatorFromElement(element) + " )");
        return newWait()
                .withTimeout(Duration.ofSeconds(FLUENT_WAIT_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(POLLING))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
