package businessobject;

import pageobject.HomePage;
import pageobject.LoginPage;
import userdata.User;

import static utils.PropertyFileHandler.MAIN_URL;

public class LoginationBO {

   private LoginPage loginPage = new LoginPage();

   public HomePage logIn(User user){
       loginPage.goToPageURL(MAIN_URL);
       loginPage.typeEmailAndSubmit(user.getEmail());
       return loginPage.typePasswordAndSubmit(user.getPassword());
   }

   public void logOut(HomePage homePage){
       homePage.logOut();
   }
}
