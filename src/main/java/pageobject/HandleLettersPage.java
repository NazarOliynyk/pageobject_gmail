package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static logger.AllureLogger.logToAllureInfo;

public class HandleLettersPage extends AbstractPage{

    @FindBy(css = "div.T-I.T-I-KE.L3")
    private WebElement composeButton;

    @FindBy(css = "div.TN.bzz.aHS-bnu")
    private WebElement getAllSentLettersButton;

    public SingleLetterPage openCreateLetterForm(){
        getElementWithWait(composeButton).click();
        logToAllureInfo("Opening a new letter form");
        return new SingleLetterPage();
    }

    public SentLettersPage getAllSentLettersPage(){
        getElementWithWaitAndPolling(getAllSentLettersButton).click();
        logToAllureInfo("Opening the page with sent letters");
        return new SentLettersPage();
    }
}
