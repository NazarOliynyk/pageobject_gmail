package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static logger.AllureLogger.logToAllureInfo;

public class SingleLetterPage extends AbstractPage {

    @FindBy(xpath = "//textarea[@class='vO']")
    private WebElement recipientInput;

    @FindBy(name = "subjectbox")
    private WebElement subjectInput;

    @FindBy(xpath = "//div[@class='Am Al editable LW-avf tS-tW']")
    private WebElement mainTextArea;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    private WebElement sendEmailButton;

    public void fillLetter(String recipientEmail, String subject, String content) {
        logToAllureInfo("Filling fields of the letter");
        waitUntilVisibilityAndGetElement(recipientInput).sendKeys(recipientEmail);
        waitUntilVisibilityAndGetElement(subjectInput).sendKeys(subject);
        waitUntilVisibilityAndGetElement(mainTextArea).sendKeys(content);
    }

    public void sendLetter() {
        waitUntilVisibilityAndGetElement(sendEmailButton).click();
        logToAllureInfo("Sending the letter");
    }
}
