package ir.moke.module.vertx.route;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloRoute implements Handler<RoutingContext> {
    private static final Logger logger = LoggerFactory.getLogger(HelloRoute.class);

    @Override
    public void handle(RoutingContext context) {
        logger.info("Request received");
        context.response().end("Hello dear !");
    }
}
