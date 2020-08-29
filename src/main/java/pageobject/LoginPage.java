package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static logger.AllureLogger.logToAllureInfo;

public class LoginPage extends AbstractPage {

    @FindBy(id= "identifierId")
    private WebElement emailInput;

    @FindBy(id = "identifierNext")
    private WebElement proceedWithEmailButton;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "passwordNext")
    private WebElement proceedWithPasswordButton;

    public void typeEmailAndSubmit(String email){
        getElementWithWait(emailInput).sendKeys(email);
        getElementWithWait(proceedWithEmailButton).click();
        logToAllureInfo("Submitting email");
    }

    public HomePage typePasswordAndSubmit(String password){
        getElementWithWait(passwordInput).sendKeys(password);
        getElementWithWait(proceedWithPasswordButton).click();
        logToAllureInfo("Submitting password and proceeding to HomePage");
        return new HomePage();
    }

}
