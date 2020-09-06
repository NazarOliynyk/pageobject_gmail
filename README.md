The project to test Logination, Creation of a new Letter, and Deleting it for Gmail post service.

**Design patterns:**

 - Page Object with @FindBy annotations and initialization via org.openqa.selenium.support.PageFactory.
 
 - Business Object with encapsulation of business logic 

 - Custom decorator which enables custom elements with specific methods. Decorator itself works with reflection to provide necessary handling of @FindBy annotations.

 
 
**Precondition of test** - Sending of a default letter to compare with the main letter by their recipient and compare the size of sent letters list before and after deleting of the main letter. Sending is done with the help of smtp mail sender. All accounts from userdata.json already support less secure apps. In order to work with a new account- logIn to google account and run the following url - https://myaccount.google.com/lesssecureapps?utm_source=google-account&utm_medium=web&hl=uk

**Parallel run** - Test uses DataProvider with 5 user-data options. Initially it runs 3 threads and 2 more after it. To run test - tape _mvn clean test_ from the command line.               

Reporting - allure.

**Recent reports** with all logs and screenshots 

https://eager-lamarr-aa773a.netlify.app/