package businessobject;

import pageobject.*;

import static logger.AllureLogger.logToAllureInfo;
import static wait.CustomWait.waitUntilDocumentReadyState;

public class DeletingLettersBO {

    private SentLettersPage sentLettersPage;

    public DeletingLettersBO() {
        sentLettersPage = new SentLettersPage();
    }

    public void deleteLastLetter() {
        sentLettersPage.selectLastLetter();
        sentLettersPage.deleteSelectedLetter();
    }

    public void cleanUpMailBox() {
        logToAllureInfo("Deleting default letter to clean up the mail box ");
        sentLettersPage.selectLastLetter();
        sentLettersPage.deleteSelectedLetter();
        waitUntilDocumentReadyState();
        logToAllureInfo("Default letter deleted ");
    }
}
