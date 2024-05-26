package ir.moke.module.common;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationVerticle extends AbstractVerticle {

    public static final ApplicationVerticle instance = new ApplicationVerticle();
    private static final Logger logger = LoggerFactory.getLogger(ApplicationVerticle.class);
    private final Router router;

    private ApplicationVerticle() {
        router = Router.router(vertx);
    }

    @Override
    public void start() {
        router.route().handler(BodyHandler.create());
    }

    public Router getRouter() {
        return router;
    }

    public void registerRoute(Handler<RoutingContext> handler, String name, String path) {
        router.get(path)
                .setName(name)
                .handler(handler);
    }

    public void removeRouteByPath(String path) {
        router.getRoutes()
                .stream()
                .filter(item -> item.getPath() != null)
                .filter(item -> item.getPath().equals(path))
                .findFirst()
                .ifPresent(Route::remove);
    }

    public void removeRouteByName(String name) {
        router.getRoutes()
                .stream()
                .filter(item -> item.getName() != null)
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .ifPresent(Route::remove);
    }
}
