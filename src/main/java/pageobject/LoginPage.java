package pageobject;

import customelement.Button;
import customelement.Input;
import org.openqa.selenium.support.FindBy;

import static logger.AllureLogger.logToAllureInfo;

public class LoginPage extends AbstractPage {

    @FindBy(id = "identifierId")
    private Input emailInput;

    @FindBy(id = "identifierNext")
    private Button proceedWithEmailButton;

    @FindBy(name = "password")
    private Input passwordInput;

    @FindBy(id = "passwordNext")
    private Button proceedWithPasswordButton;

    public void typeEmailAndSubmit(String email) {
        logToAllureInfo("Submitting email");
        emailInput.waitClearAndSendKeys(email);
        proceedWithEmailButton.waitAndClick();
    }

    public void typePasswordAndSubmit(String password) {
        logToAllureInfo("Submitting password and proceeding to HomePage");
        passwordInput.waitWithPollingAndSendKeys(password);
        proceedWithPasswordButton.waitAndClick();
    }
}
