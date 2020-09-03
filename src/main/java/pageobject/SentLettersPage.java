package pageobject;

import customelement.Button;
import customelement.CheckBox;
import customelement.LetterItem;
import customelement.TextHolder;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static logger.AllureLogger.logToAllureInfo;
import static logger.AllureLogger.logToAllureWarn;

public class SentLettersPage extends AbstractPage {

    private static final String LETTER_ITEM_LOCATOR =
            "//div[@class='BltHke nH oy8Mbf']//div[@class='Cp' and preceding-sibling::div[@class='Cp']]//table/tbody/tr";

    @FindBy(xpath = LETTER_ITEM_LOCATOR)
    private List<LetterItem> allLetters;

    @FindBy(xpath = LETTER_ITEM_LOCATOR + "[1]//span[@class='bog']/span")
    private TextHolder subjectOfTheLastLetterTag;

    @FindBy(xpath = LETTER_ITEM_LOCATOR + "[1]/td[@class='xW xY ']/span")
    private TextHolder timeTagOfTheLastLetter;

    @FindBy(xpath = LETTER_ITEM_LOCATOR + "[1]/td[@class='oZ-x3 xY']")
    private CheckBox selectLastLetterCheckBox;

    @FindBy(xpath = LETTER_ITEM_LOCATOR + "[1]/td[@class='bq4 xY']/ul/li[@class='bqX bru']")
    private Button deleteSelectedLetterButton;

    public int getSizeOfLettersList() {
        int size = allLetters.size();
        logToAllureInfo("Calculating the size of letter List: " + size);
        return size;
    }

    public String getLastLetterSubject() {
        logToAllureWarn("Getting text from the subject of a letter ");
        return subjectOfTheLastLetterTag.waitUntilDocumentIsReadyAndGetText();
    }

    public String getExactTimeOfTheLastLetterInList() {
        String exactTime = timeTagOfTheLastLetter.waitUntilDocumentIsReadyAndGetAttribute("title");
        logToAllureWarn("Getting exact time from the last letter in the list of letters: " + exactTime);
        return exactTime;
    }

    public void selectLastLetter() {
        logToAllureInfo("Selecting last letter check box");
        selectLastLetterCheckBox.setChecked();
    }

    public void deleteSelectedLetter() {
        logToAllureInfo("Deleting selected letter");
        deleteSelectedLetterButton.waitUntilDocumentIsReadyAndClick();
    }
}
