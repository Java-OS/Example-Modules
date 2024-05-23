package ir.moke.module.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogService {
    private static final Logger logger = LoggerFactory.getLogger(LogService.class);

    public static void generateLog() {
        while (true) {
            sleep();
            sendInfoLog();
            sendWarnLog();
            sendDebugLog();
            sendErrorLog();
            sendTraceLog();
        }
    }

    public static void sendInfoLog() {
        logger.info("This is info log");
    }

    public static void sendDebugLog() {
        logger.debug("This is debug log");
    }

    public static void sendWarnLog() {
        logger.warn("This is warn log");
    }

    public static void sendErrorLog() {
        logger.error("This is error log");
    }

    public static void sendTraceLog() {
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
