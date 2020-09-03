package pageobject;

import customdecorator.CustomFieldDecorator;
import driver.DriverManager;
import org.openqa.selenium.support.PageFactory;

import static logger.AllureLogger.logToAllureInfo;

public abstract class AbstractPage {

    AbstractPage() {
        logToAllureInfo("Initialize PageFactory in: " + this.getClass().getName());
        PageFactory.initElements(new CustomFieldDecorator(DriverManager.getDriver()), this);
    }

    public void goToPageURL(final String url) {
        logToAllureInfo("Going to URL: " + url);
        DriverManager.getDriver().get(url);
    }
}
