package customelement;

import customelement.abstraction.Element;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static logger.AllureLogger.logToAllureDebug;
import static utils.Utils.newWait;
import static utils.Utils.waitUntilDocumentReadyState;

public class Button extends Element {

    public Button(WebElement webElement) {
        super(webElement);
    }

    public void waitAndClick() {
        logToAllureDebug("Waiting and Clicking the Custom-button: " + getLocator());
        newWait().until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    public void waitUntilDocumentIsReadyAndClick() {
        logToAllureDebug("Waiting for the document ready state and Clicking the Custom-button: " + getLocator());
        waitUntilDocumentReadyState();
        newWait().until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    public void waitWithPollingUntilDocumentIsReadyAndClick() {
        logToAllureDebug("Waiting with polling for the document ready state and Clicking the Custom-button: " + getLocator());
        waitUntilDocumentReadyState();
        waitWithPollingUntilVisibilityAndGetElement(webElement).click();
    }

}
