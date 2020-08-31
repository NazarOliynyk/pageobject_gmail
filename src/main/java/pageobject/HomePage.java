package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static logger.AllureLogger.logToAllureInfo;
import static utils.Utils.isDisplayed;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//img[@class='gb_La gbii']")
    private WebElement accountWindow;

    @FindBy(id = "gb_71")
    private WebElement exitButton;

    public boolean isAccountOptionsPresent() {
        return isDisplayed(waitUntilVisibilityAndGetElement(accountWindow));
    }

    public void logOut() {
        logToAllureInfo("Log out from the Account");
        waitUntilVisibilityAndGetElement(accountWindow).click();
        waitUntilVisibilityAndGetElement(exitButton).click();
    }

}
