package com.sample.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;

public class LogService {
    private static final Logger logger = LoggerFactory.getLogger(LogService.class);

    public static void generateLog(ExecutorService es) {
        while (!es.isShutdown()) {
            es.execute(LogService::sendInfoLog);
            es.execute(LogService::sendWarnLog);
            es.execute(LogService::sendDebugLog);
            es.execute(LogService::sendErrorLog);
            es.execute(LogService::sendTraceLog);
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
}
