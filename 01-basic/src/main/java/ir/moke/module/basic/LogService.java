package ir.moke.module.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogService {
    private static final Logger logger = LoggerFactory.getLogger(LogService.class);

    public static void generateLog(boolean enable) {
        while (enable) {
            sleep();
            sendInfoLog();
            sendWarnLog();
            sendDebugLog();
            sendErrorLog();
            sendTraceLog();
        }
    }

    private static void sendInfoLog() {
        logger.info("This is info log");
    }

    private static void sendDebugLog() {
        logger.debug("This is debug log");
    }

    private static void sendWarnLog() {
        logger.warn("This is warn log");
    }

    private static void sendErrorLog() {
        logger.error("This is error log");
    }

    private static void sendTraceLog() {
        logger.trace("This is trace log");
    }

    public static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
