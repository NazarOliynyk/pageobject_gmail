package businessobject;

import dto.SentLettersDTO;
import pageobject.HandleLettersPage;
import pageobject.SentLettersPage;
import pageobject.SingleLetterPage;

import static utils.Utils.waitUntilDocumentReadyState;

public class SendingLettersBO {

    private HandleLettersPage handleLettersPage = new HandleLettersPage();

    public SentLettersPage sendNewLetter(String recipientEmail, String subject, String content){
        SingleLetterPage singleLetterPage = handleLettersPage.openCreateLetterForm();
        singleLetterPage.fillLetter(recipientEmail, subject, content);
        singleLetterPage.sendLetter();
        return handleLettersPage.getAllSentLettersPage();
    }

    public SentLettersDTO getStateOfTheLettersList(SentLettersPage sentLettersPage){
        SentLettersDTO sentLettersDTO = new SentLettersDTO();
        sentLettersDTO.setSizeOfLettersList(sentLettersPage.getSizeOfLettersList());
        sentLettersDTO.setExactTimeOfTheLastLetter(sentLettersPage.getExactTimeOfTheLastLetterInList());
        return sentLettersDTO;
    }

}
