package pageobject;

import customelement.Button;
import customelement.PopUp;
import org.openqa.selenium.support.FindBy;

import static logger.AllureLogger.logToAllureInfo;
import static logger.AllureLogger.logToAllureWarn;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//img[@class='gb_Ia gbii']")
    private PopUp accountWindow;

    @FindBy(id = "gb_71")
    private Button exitButton;

    public boolean areAccountOptionsPresent() {
        logToAllureWarn("Verifying if account window is displayed ");
        return accountWindow.isDisplayed();
    }

    public void logOut() {
        logToAllureInfo("Log out from the Account");
        accountWindow.openPopUp();
        exitButton.waitAndClick();
    }
}
