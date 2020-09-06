package pageobject;

import customdecorator.CustomFieldDecorator;
import driver.DriverManager;
import org.openqa.selenium.support.PageFactory;

import static logger.AllureLogger.logToAllureInfo;

abstract class AbstractPage {

    AbstractPage() {
        logToAllureInfo("Initialize PageFactory in: " + this.getClass().getName());
        PageFactory.initElements(new CustomFieldDecorator(DriverManager.getDriver()), this);
    }
}
