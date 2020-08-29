package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static logger.AllureLogger.logToAllureInfo;

public class PropertyFileHandler {
    public static final String CHROME_DRIVER;
    public static final String GECKO_DRIVER;
    public static final String CHROME_DRIVER_PATH;
    public static final String GECKO_DRIVER_PATH;
    public static final String MAIN_URL;
    public static final String RECIPIENT_EMAIL;
    public static final String SUBJECT;
    public static final String CONTENT;
    public static final int FLUENT_WAIT_TIMEOUT;
    public static final int POLLING;

    static {
        Properties prop = new Properties();
        try (InputStream input =
                     new FileInputStream("src\\main\\resources\\config.properties")) {
            prop.load(input);
            logToAllureInfo("Constants are extracted from the property file");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        CHROME_DRIVER = prop.getProperty("chromedriver");
        GECKO_DRIVER = prop.getProperty("geckodriver");
        GECKO_DRIVER_PATH = prop.getProperty("geckodriverPath");
        CHROME_DRIVER_PATH = prop.getProperty("chromedriverPath");
        MAIN_URL = prop.getProperty("main_url");
        RECIPIENT_EMAIL = prop.getProperty("recipient_email");
        SUBJECT = prop.getProperty("subject");
        CONTENT = prop.getProperty("content");
        FLUENT_WAIT_TIMEOUT = Integer.parseInt(prop.getProperty("timeout"));
        POLLING = Integer.parseInt(prop.getProperty("polling"));
    }

}
