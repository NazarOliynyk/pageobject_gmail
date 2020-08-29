package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static logger.AllureLogger.logToAllureInfo;

public class HomePage extends AbstractPage{

    @FindBy(xpath = "//img[@class='gb_La gbii']")
    private WebElement accountWindow;

    @FindBy(id = "gb_71")
    private WebElement exitButton;

    public boolean isAccountOptionsPresent(){
        return isDisplayed(getElementWithWait(accountWindow));
    }

    public void logOut(){
        getElementWithWait(accountWindow).click();
        getElementWithWait(exitButton).click();
        logToAllureInfo("Log out from the Account");
    }

}
