package customelement;

import customelement.abstraction.Element;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static logger.AllureLogger.logToAllureDebug;
import static utils.Utils.newWait;
import static utils.Utils.waitUntilDocumentReadyState;

public class TextHolder extends Element {

    public TextHolder(WebElement webElement) {
        super(webElement);
    }

    public String waitUntilDocumentIsReadyAndGetText() {
        logToAllureDebug("Waiting and getting the text from custom text-holder: " + getLocator());
        waitUntilDocumentReadyState();
        return newWait().until(ExpectedConditions.visibilityOf(webElement)).getText();
    }

    public String waitUntilDocumentIsReadyAndGetAttribute(String attribute) {
        logToAllureDebug("Waiting and getting the attribute from custom text-holder: " + getLocator());
        waitUntilDocumentReadyState();
        return webElement.getAttribute(attribute);
    }
}
