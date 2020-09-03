package pageobject;

import customelement.Button;
import org.openqa.selenium.support.FindBy;

import static logger.AllureLogger.logToAllureInfo;

public class HandleLettersPage extends AbstractPage {

    @FindBy(css = "div.T-I.T-I-KE.L3")
    private Button composeButton;

    @FindBy(css = "div.TN.bzz.aHS-bnu")
    private Button getAllSentLettersButton;

    public SingleLetterPage openCreateLetterForm() {
        logToAllureInfo("Opening a new letter form");
        composeButton.waitAndClick();
        return new SingleLetterPage();
    }

    public SentLettersPage getAllSentLettersPage() {
        logToAllureInfo("Opening the page with sent letters");
        getAllSentLettersButton.waitWithPollingUntilDocumentIsReadyAndClick();
        return new SentLettersPage();
    }
}
