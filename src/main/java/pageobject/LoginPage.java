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
        logToAllureInfo("Submitting email");
        waitUntilVisibilityAndGetElement(emailInput).sendKeys(email);
        waitUntilVisibilityAndGetElement(proceedWithEmailButton).click();
    }

    public HomePage typePasswordAndSubmit(String password){
        logToAllureInfo("Submitting password and proceeding to HomePage");
        waitUntilVisibilityAndGetElement(passwordInput).sendKeys(password);
        waitUntilVisibilityAndGetElement(proceedWithPasswordButton).click();
        return new HomePage();
    }

}
