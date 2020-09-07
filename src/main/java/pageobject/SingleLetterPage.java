package pageobject;

import customelement.Button;
import customelement.Input;
import dto.MessageDTO;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static logger.AllureLogger.logToAllureInfo;
import static wait.CustomWait.waitUntilVisibilityAndGetElement;

public class SingleLetterPage extends AbstractPage {

    @FindBy(xpath = "//textarea[@class='vO']")
    private Input recipientInput;

    @FindBy(name = "subjectbox")
    private WebElement subjectInput;

    @FindBy(xpath = "//div[@class='Am Al editable LW-avf tS-tW']")
    private Input mainTextArea;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    private Button sendEmailButton;

    public void fillLetter(MessageDTO messageDTO) {
        logToAllureInfo("Filling fields of the letter");
        recipientInput.waitWithPollingAndSendKeys(messageDTO.getRecipientEmail());
        waitUntilVisibilityAndGetElement(subjectInput).sendKeys(messageDTO.getSubject());
        mainTextArea.waitWithPollingAndSendKeys(messageDTO.getContent());
    }

    public void sendLetter() {
        logToAllureInfo("Sending the letter");
        sendEmailButton.waitUntilDocumentIsReadyAndClick();
    }
}
