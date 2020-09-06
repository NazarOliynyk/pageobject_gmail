package businessobject;

import pageobject.*;
import userdata.User;

public class LoginationBO {

    private LoginPage loginPage;

    private HomePage homePage;

    public LoginationBO() {
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    public void logIn(User user) {
        loginPage.typeEmailAndSubmit(user.getEmail());
        loginPage.typePasswordAndSubmit(user.getPassword());
    }

    public boolean areAccountOptionsPresent() {
        return homePage.areAccountOptionsPresent();
    }

}
