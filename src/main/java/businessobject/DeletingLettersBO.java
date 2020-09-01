package businessobject;

import pageobject.SentLettersPage;

public class DeletingLettersBO {

    public SentLettersPage deleteLastLetter(SentLettersPage sentLettersPage){
        sentLettersPage.selectLastLetter();
        sentLettersPage.deleteSelectedLetter();
        return sentLettersPage;
    }

}
