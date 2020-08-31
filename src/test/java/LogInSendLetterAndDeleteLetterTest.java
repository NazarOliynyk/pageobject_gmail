import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.*;

import static utils.PropertyFileHandler.*;

public class LogInSendLetterAndDeleteLetterTest extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Description("Verify Sending and Deleting of a letter")
    @Step("Verify Sending and Deleting of a letter")
    public void testSendAndDeleteLetter() {

        LoginPage loginPage = new LoginPage();
        loginPage.goToPageURL(MAIN_URL);
        loginPage.typeEmailAndSubmit(user.getEmail());
        HomePage homePage = loginPage.typePasswordAndSubmit(user.getPassword());
        Assert.assertTrue(homePage.isAccountOptionsPresent(), "Logination failed");

        HandleLettersPage handleLettersPage = new HandleLettersPage();
        SingleLetterPage singleLetterPage = handleLettersPage.openCreateLetterForm();
        singleLetterPage.fillLetter(RECIPIENT_EMAIL, SUBJECT, CONTENT);
        singleLetterPage.sendLetter();

        SentLettersPage sentLettersPage = handleLettersPage.getAllSentLettersPage();
        int sizeOfListAfterSaving = sentLettersPage.getSizeOfLettersList();
        Assert.assertEquals(sentLettersPage.getLastLetterSubject(),
                SUBJECT, " Subject of the letter does not match !");

        sentLettersPage.selectLastLetter();
        sentLettersPage.deleteSelectedLetter();
        int sizeOfListAfterDeleting = sentLettersPage.getSizeOfLettersList();
        Assert.assertEquals(sizeOfListAfterSaving - sizeOfListAfterDeleting, 1,
                " Deleting of the letter failed !");
    }
}
