package ir.moke.module.api;

import io.vertx.ext.web.RoutingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloRoute {
    public static final String ROUTE_NAME = "hello";
    public static final String ROUTE_PATH = "/hello";
    private static final Logger logger = LoggerFactory.getLogger(HelloRoute.class);

    public static void handle(RoutingContext context) {
        logger.info("Hello API , Request received");
        context.response().send("Hello dear !");
    }
}
