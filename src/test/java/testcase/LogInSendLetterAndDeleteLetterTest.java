package testcase;

import businessobject.DeletingLettersBO;
import businessobject.LoginationBO;
import businessobject.SendingLettersBO;
import io.qameta.allure.*;
import model.SentLettersDTO;
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

        LoginationBO loginationBO = new LoginationBO();
        HomePage homePage = loginationBO.logIn(user);
        Assert.assertTrue(homePage.isAccountOptionsPresent(), "Logination failed");

        SendingLettersBO sendingLettersBO = new SendingLettersBO();
        SentLettersPage sentLettersPage = sendingLettersBO.sendNewLetter(RECIPIENT_EMAIL, SUBJECT, CONTENT);
        Assert.assertEquals(sentLettersPage.getLastLetterSubject(),
                SUBJECT, " Subject of the letter does not match !");
        SentLettersDTO dtoAfterSending = sendingLettersBO.getStateOfTheLettersList(sentLettersPage);

        DeletingLettersBO deletingLettersBO = new DeletingLettersBO();
        deletingLettersBO.deleteLastLetter(sentLettersPage);
        SentLettersDTO dtoAfterDeleting = sendingLettersBO.getStateOfTheLettersList(sentLettersPage);

        Assert.assertNotEquals(dtoAfterSending.getSizeOfLettersList(), dtoAfterDeleting.getSizeOfLettersList(),
                "The size of the sent letters page did not change after deleting !");
        Assert.assertNotEquals(dtoAfterSending.getExactTimeOfTheLastLetter(), dtoAfterDeleting.getExactTimeOfTheLastLetter(),
                "The state of the sent letters page did not change after deleting !");

    }
}
