package ir.moke.module.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import ir.moke.module.vertx.route.HelloRoute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class VertxStandaloneServer extends AbstractVerticle {
    public static final VertxStandaloneServer instance = new VertxStandaloneServer();
    private static final Logger logger = LoggerFactory.getLogger(VertxStandaloneServer.class);
    private static final String port = System.getenv("VERTX_HTTP_PORT");
    private static Router router;
    private static HttpServer httpServer;

    private VertxStandaloneServer() {
        router = Router.router(vertx);
        router.route().handler(BodyHandler.create());

        router.get("/hello").handler(new HelloRoute());
    }

    public void start() {
        logger.info("Vertx server started");
        HttpServer httpServer = vertx.createHttpServer();
        httpServer.requestHandler(router).listen(Integer.parseInt(Optional.ofNullable(port).orElse("8080")));
    }

    public void stop() {
        try {
            httpServer.close();
            logger.info("Vertx server stopped");
        } catch (Exception e) {
            logger.error("Vertx error", e);
        }
    }
}
