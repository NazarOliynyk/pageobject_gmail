package customelement;

import customelement.abstraction.Element;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static logger.AllureLogger.logToAllureDebug;
import static wait.CustomWait.getNewFluentWait;
import static wait.CustomWait.waitUntilDocumentReadyState;
import static wait.CustomWait.waitWithPollingUntilVisibilityAndGetElement;

public class Button extends Element {

    public Button(WebElement webElement) {
        super(webElement);
    }

    public void waitAndClick() {
        logToAllureDebug("Waiting and Clicking the Custom-button: " + getLocator());
        getNewFluentWait().until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    public void waitUntilDocumentIsReadyAndClick() {
        logToAllureDebug("Waiting for the document ready state and Clicking the Custom-button: " + getLocator());
        waitUntilDocumentReadyState();
        getNewFluentWait().until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    public void waitWithPollingUntilDocumentIsReadyAndClick() {
        logToAllureDebug("Waiting with polling for the document ready state and Clicking the Custom-button: " + getLocator());
        waitUntilDocumentReadyState();
        waitWithPollingUntilVisibilityAndGetElement(webElement).click();
    }
}
