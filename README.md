The project to test Logination, Creation of a new Letter, and Deleting it for Gmail post service.

**Design patterns:**
 1. Page Object with @FindBy annotations and initialization via org.openqa.selenium.support.PageFactory.
 
 2.  Business Object with encapsulation of business logic 

**Precondition of test** - Sending of a default letter to compare with the initial letter by their time of sending                   

Reporting - allure.

**Recent reports** with all logs in Set up (sending a default letter), Test body (Sending an initial letter, deleting it, verifying the size of letters list and time of the letter), Tear down (deleting of the default letter to clean up the mail box)-

https://quirky-allen-b0e307.netlify.app/