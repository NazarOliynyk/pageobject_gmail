package businessobject;

import pageobject.HomePage;
import pageobject.SentLettersPage;

public class DeletingLettersBO {

    public void deleteLastLetter(SentLettersPage sentLettersPage){
        sentLettersPage.selectLastLetter();
        sentLettersPage.deleteSelectedLetter();
    }

    public void deleteDefaultLetter(){
        SentLettersPage sentLettersPage = new SentLettersPage();
        sentLettersPage.selectLastLetter();
        sentLettersPage.deleteSelectedLetter();
        sentLettersPage.waitUntilDocumentReadyState();
        new HomePage().logOut();
    }
}
