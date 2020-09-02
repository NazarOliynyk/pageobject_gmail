package utils;

import businessobject.DeletingLettersBO;
import businessobject.LoginationBO;
import businessobject.SendingLettersBO;
import driver.DriverManager;
import org.testng.Assert;
import pageobject.SentLettersPage;
import userdata.User;

import static logger.AllureLogger.logToAllureWarn;
import static utils.PropertyFileHandler.DEFAULT_CONTENT;
import static utils.PropertyFileHandler.DEFAULT_SUBJECT;
import static utils.PropertyFileHandler.RECIPIENT_EMAIL;

public class TestUtils {

    public static void sendDefaultLetter(User user){
        logToAllureWarn("Sending Default letter to fill the folder of letters");
        LoginationBO loginationBO = new LoginationBO();
        loginationBO.logIn(user);
        SendingLettersBO sendingLettersBO = new SendingLettersBO();
        SentLettersPage sentLettersPage =
                sendingLettersBO.sendNewLetter(RECIPIENT_EMAIL, DEFAULT_SUBJECT, DEFAULT_CONTENT);
        Assert.assertEquals(sentLettersPage.getLastLetterSubject(),
                DEFAULT_SUBJECT, " Subject of the default letter does not match !");
        DriverManager.quitDriver();
    }

    public static void deleteDefaultLetter(){
        logToAllureWarn("Deleting default letter from the folder ");
        DeletingLettersBO deletingLettersBO = new DeletingLettersBO();
        deletingLettersBO.deleteDefaultLetter();
    }
}
