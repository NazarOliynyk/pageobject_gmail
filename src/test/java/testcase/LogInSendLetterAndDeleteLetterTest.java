package testcase;

import businessobject.DeletingLettersBO;
import businessobject.LoginationBO;
import businessobject.SendingLettersBO;
import driver.DriverManager;
import dto.MessageDTO;
import io.qameta.allure.*;
import dto.SentLettersDTO;
import org.testng.Assert;
import org.testng.annotations.*;
import smtpservice.MailSender;
import userdata.User;

import java.util.Iterator;
import java.util.List;

import static utils.PropertyFileHandler.*;
import static utils.Utils.goToPageURL;
import static utils.Utils.initializeUserData;


@Listeners({CustomListeners.class})
public class LogInSendLetterAndDeleteLetterTest {

    @DataProvider(parallel = true)
    public Iterator<Object[]> users() {
        List<User> userList = initializeUserData();
        return userList.stream().map(user -> new Object[]{user}).iterator();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "users")
    @Description("Verify Sending and Deleting of a letter")
    @Step("Verify Sending and Deleting of a letter")
    public void testSendAndDeleteLetter(User user) {

        LoginationBO loginationBO = new LoginationBO();

        SendingLettersBO sendingLettersBO = new SendingLettersBO();

        DeletingLettersBO deletingLettersBO = new DeletingLettersBO();
        new MailSender().sendDefaultMessage(user);
        goToPageURL(MAIN_URL);
        loginationBO.logIn(user);
        Assert.assertTrue(loginationBO.areAccountOptionsPresent(), " Logination failed");

        MessageDTO messageDTO = new MessageDTO();
        sendingLettersBO.sendNewLetter(messageDTO);

        Assert.assertEquals(sendingLettersBO.getLastLetterSubject(), messageDTO.getSubject(),
                " Subject of the letter does not match !");
        SentLettersDTO dtoAfterSending = sendingLettersBO.getStateOfTheLettersList(ATTRIBUTE_EMAIL);

        deletingLettersBO.deleteLastLetter();
        SentLettersDTO dtoAfterDeleting = sendingLettersBO.getStateOfTheLettersList(ATTRIBUTE_EMAIL);

        Assert.assertNotEquals(dtoAfterSending.getSizeOfLettersList(), dtoAfterDeleting.getSizeOfLettersList(),
                " The size of the sent letters page has not changed after deleting !");
        Assert.assertNotEquals(dtoAfterSending.getRecipientEmailOfTheLastLetter(), dtoAfterDeleting.getRecipientEmailOfTheLastLetter(),
                " The recipientEmail of the last letter has not changed after deleting  !");

        deletingLettersBO.cleanUpMailBox();
    }

    @AfterMethod
    public void afterMethod() {
        DriverManager.quitDriver();
    }

}
