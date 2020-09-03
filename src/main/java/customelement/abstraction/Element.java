package customelement.abstraction;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static utils.PropertyFileHandler.FLUENT_WAIT_TIMEOUT;
import static utils.PropertyFileHandler.POLLING;
import static utils.Utils.newWait;

public abstract class Element implements IElement {

    protected WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    protected String getLocator() {
        return "( " + StringUtils.removeEnd(webElement.toString().substring(73), "]") + " )";

    }

    protected WebElement waitWithPollingUntilVisibilityAndGetElement(WebElement element) {
        return newWait()
                .withTimeout(Duration.ofSeconds(FLUENT_WAIT_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(POLLING))
                .until(ExpectedConditions.visibilityOf(element));
    }
}