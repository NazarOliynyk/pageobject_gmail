package pageobject;

import customelement.Button;
import customelement.Input;
import org.openqa.selenium.support.FindBy;

import static logger.AllureLogger.logToAllureInfo;

public class SingleLetterPage extends AbstractPage {

    @FindBy(xpath = "//textarea[@class='vO']")
    private Input recipientInput;

    @FindBy(name = "subjectbox")
    private Input subjectInput;

    @FindBy(xpath = "//div[@class='Am Al editable LW-avf tS-tW']")
    private Input mainTextArea;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    private Button sendEmailButton;

    public void fillLetter(String recipientEmail, String subject, String content) {
        logToAllureInfo("Filling fields of the letter");
        recipientInput.waitClearAndSendKeys(recipientEmail);
        subjectInput.waitClearAndSendKeys(subject);
        mainTextArea.waitClearAndSendKeys(content);
    }

    public void sendLetter() {
        logToAllureInfo("Sending the letter");
        sendEmailButton.waitAndClick();
    }
}
