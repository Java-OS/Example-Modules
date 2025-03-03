package ir.moke.module.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

public class LogService extends TimerTask {
    private static final Logger logger = LoggerFactory.getLogger(LogService.class);

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

    @Override
    public void run() {
        sendInfoLog();
        sendWarnLog();
        sendDebugLog();
        sendErrorLog();
        sendTraceLog();
    }
}
