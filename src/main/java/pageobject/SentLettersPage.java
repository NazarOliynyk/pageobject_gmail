package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static logger.AllureLogger.logToAllureInfo;
import static logger.AllureLogger.logToAllureWarn;

public class SentLettersPage extends AbstractPage {

    private static final String LETTER_ITEM_LOCATOR =
            "//div[@class='BltHke nH oy8Mbf']//div[@class='Cp' and preceding-sibling::div[@class='Cp']]//table/tbody/tr";

    @FindBy(xpath = LETTER_ITEM_LOCATOR)
    private List<WebElement> allLetters;

    @FindBy(xpath = LETTER_ITEM_LOCATOR + "[1]//span[@class='bog']/span")
    private WebElement subjectOfTheLastLetterTag;

    @FindBy(xpath = LETTER_ITEM_LOCATOR + "[1]/td[@class='oZ-x3 xY']")
    private WebElement selectLastLetterCheckBox;

    @FindBy(xpath = LETTER_ITEM_LOCATOR + "[1]/td[@class='bq4 xY']/ul/li[@class='bqX bru']")
    private WebElement deleteSelectedLetterIcon;

    public String getLastLetterSubject() {
        logToAllureWarn("Getting text from the subject of a letter ");
        waitUntilDocumentReadyState();
        return waitUntilVisibilityAndGetElement(subjectOfTheLastLetterTag).getText();
    }

    public int getSizeOfLettersList() {
        waitUntilDocumentReadyState();
        int size = allLetters.size();
        logToAllureInfo("Calculating the size of letter List: " + size);
        return size;
    }

    public void selectLastLetter() {
        logToAllureInfo("Selecting last letter check box");
        waitUntilDocumentReadyState();
        waitWithPollingUntilVisibilityAndGetElement(selectLastLetterCheckBox).click();
    }

    public void deleteSelectedLetter() {
        logToAllureInfo("Deleting selected letter");
        waitUntilVisibilityAndGetElement(deleteSelectedLetterIcon).click();
    }

}
