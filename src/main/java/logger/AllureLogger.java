package logger;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AllureLogger {

    private static final Logger logger = LogManager.getLogger(AllureLogger.class);

    @Step("{0}")
    public static void logToAllureInfo(String log) {
        logger.info(log);
    }

    @Step("{0}")
    public static void logToAllureDebug(String log) {
        logger.debug(log);
    }

    @Step("{0}")
    public static void logToAllureError(String log) {
        logger.error(log);
    }

    @Step("{0}")
    public static void logToAllureWarn(String log) {
        logger.warn(log);
    }
}