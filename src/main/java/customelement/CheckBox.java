package customelement;

import customelement.abstraction.Element;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static logger.AllureLogger.logToAllureDebug;
import static logger.AllureLogger.logToAllureError;
import static utils.Utils.newWait;

public class CheckBox extends Element {

    public CheckBox(WebElement webElement) {
        super(webElement);
    }

    public void setChecked() {
        logToAllureDebug("Checking the customelement: " + getLocator());
        if (!isChecked()) {
            webElement.click();
        }
    }

    private boolean isChecked() {
        boolean flag = false;
        try {
            logToAllureDebug("Waiting and Verifying if Custom check-box: " + getLocator() + " is checked");
            flag = newWait().until(ExpectedConditions.visibilityOf(webElement)).isSelected();
        } catch (NoSuchElementException | TimeoutException e) {
            logToAllureError("While looking for the Custom element: " + getLocator() + " throw an Exception: " + e.getMessage());
        }
        return flag;
    }
}