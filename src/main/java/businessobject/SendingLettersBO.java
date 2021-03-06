package businessobject;

import dto.MessageDTO;
import dto.SentLettersDTO;
import pageobject.*;

public class SendingLettersBO {

    private HandleLettersPage handleLettersPage;

    private SingleLetterPage singleLetterPage;

    private SentLettersPage sentLettersPage;

    public SendingLettersBO() {
        handleLettersPage = new HandleLettersPage();
        sentLettersPage = new SentLettersPage();
        singleLetterPage = new SingleLetterPage();
    }

    public void sendNewLetter(MessageDTO messageDTO) {
        handleLettersPage.openCreateLetterForm();
        singleLetterPage.fillLetter(messageDTO);
        singleLetterPage.sendLetter();
    }

    public String getLastLetterSubject() {
        handleLettersPage.getAllSentLettersPage();
        return sentLettersPage.getLastLetterSubject();
    }

    public SentLettersDTO getStateOfTheLettersList(String tagAttribute) {
        SentLettersDTO sentLettersDTO = new SentLettersDTO();
        sentLettersDTO.setSizeOfLettersList(sentLettersPage.getSizeOfLettersList());
        sentLettersDTO.setRecipientEmailOfTheLastLetter(sentLettersPage.getRecipientEmailOfTheLastLetter(tagAttribute));
        return sentLettersDTO;
    }
}
