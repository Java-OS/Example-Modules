package ir.moke.module.api;

import io.vertx.ext.web.RoutingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class byeRoute {
    public static final String ROUTE_NAME = "bye";
    public static final String ROUTE_PATH = "/bye";
    private static final Logger logger = LoggerFactory.getLogger(byeRoute.class);
    private static final Random random = new Random();

    public static void handle(RoutingContext context) {
        logger.info("Request received");
        context.response().send("bye bye !");
    }
}
