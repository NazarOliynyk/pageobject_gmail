package customelement;

import customelement.abstraction.Element;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static logger.AllureLogger.*;
import static utils.Utils.newWait;
import static utils.Utils.waitUntilDocumentReadyState;

public class PopUp extends Element {

    public PopUp(WebElement webElement) {
        super(webElement);
    }

    public void openPopUp() {
        logToAllureDebug("Waiting and opening Custom popup: " + getLocator());
        waitUntilDocumentReadyState();
        newWait().until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    public boolean isDisplayed() {
        try {
            logToAllureInfo("Checking if custom popup: ( " + getLocator() + " ) is displayed");
            return newWait().until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            logToAllureWarn("Custom element: ( " + getLocator() + " ) is NOT displayed");
            return false;
        }
    }
}
