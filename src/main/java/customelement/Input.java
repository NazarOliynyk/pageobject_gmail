package customelement;

import customelement.abstraction.Element;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static logger.AllureLogger.logToAllureDebug;
import static wait.CustomWait.getNewFluentWait;
import static wait.CustomWait.waitUntilDocumentReadyState;
import static wait.CustomWait.waitWithPollingUntilVisibilityAndGetElement;

public class Input extends Element {

    public Input(WebElement webElement) {
        super(webElement);
    }

    public void waitAndSendKeys(String keys) {
        logToAllureDebug("Waiting for the ready state of document and sending keys to Custom input: " + getLocator());
        getNewFluentWait().until(ExpectedConditions.visibilityOf(webElement)).sendKeys(keys);
    }

    public void waitClearAndSendKeys(String keys) {
        logToAllureDebug("Waiting, clearing and sending keys to Custom input: " + getLocator());
        getNewFluentWait().until(ExpectedConditions.visibilityOf(webElement)).clear();
        webElement.sendKeys(keys);
    }

    public void waitWithPollingAndSendKeys(String keys) {
        logToAllureDebug("Waiting, clearing and sending keys to Custom input: " + getLocator());
        waitUntilDocumentReadyState();
        waitWithPollingUntilVisibilityAndGetElement(webElement).sendKeys(keys);
    }
}
