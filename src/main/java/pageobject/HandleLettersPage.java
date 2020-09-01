package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static logger.AllureLogger.logToAllureInfo;

public class HandleLettersPage extends AbstractPage {

    @FindBy(css = "div.T-I.T-I-KE.L3")
    private WebElement composeButton;

    @FindBy(css = "div.TN.bzz.aHS-bnu")
    private WebElement getAllSentLettersButton;

    public SingleLetterPage openCreateLetterForm(){
        logToAllureInfo("Opening a new letter form");
        waitUntilVisibilityAndGetElement(composeButton).click();
        return new SingleLetterPage();
    }

    public SentLettersPage getAllSentLettersPage(){
        logToAllureInfo("Opening the page with sent letters");
        waitUntilDocumentReadyState();
        waitWithPollingUntilVisibilityAndGetElement(getAllSentLettersButton).click();
        return new SentLettersPage();
    }
}
