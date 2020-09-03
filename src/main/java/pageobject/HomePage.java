package pageobject;

import customelement.Button;
import customelement.PopUp;
import org.openqa.selenium.support.FindBy;

import static logger.AllureLogger.logToAllureInfo;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//img[@class='gb_La gbii']")
    private PopUp accountWindow;

    @FindBy(id = "gb_71")
    private Button exitButton;

    public boolean isAccountOptionsPresent() {
        return accountWindow.isDisplayed();
    }

    public void logOut() {
        logToAllureInfo("Log out from the Account");
        accountWindow.openPopUp();
        exitButton.waitAndClick();
    }
}
