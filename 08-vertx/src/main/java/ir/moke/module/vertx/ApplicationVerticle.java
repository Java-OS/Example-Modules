package ir.moke.module.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationVerticle extends AbstractVerticle {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationVerticle.class);
    private final Router router;

    public ApplicationVerticle() {
        router = Router.router(vertx);
    }

    private static void helloHandler(RoutingContext context) {
        logger.info("Request received");
        context.response().send("Hello dear !");
    }

    @Override
    public void start() {
        router.route().handler(BodyHandler.create());
        router.get("/hello").handler(ApplicationVerticle::helloHandler);
    }

    public Router getRouter() {
        return router;
    }
}
