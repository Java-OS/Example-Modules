package ir.moke.module.vertx.engine;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import ir.moke.module.vertx.common.ApplicationVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class VertxContainer {
    public static final VertxContainer instance = new VertxContainer();
    private static final Logger logger = LoggerFactory.getLogger(VertxContainer.class);
    private static final Vertx vertx = Vertx.vertx();
    private static final String port = System.getenv("VERTX_HTTP_PORT");
    private static HttpServer httpServer;

    private VertxContainer() {

    }

    private static Router deployVerticle() {
        vertx.deployVerticle(ApplicationVerticle.instance);
        return ApplicationVerticle.instance.getRouter();
    }

    public void start() {
        try {
            logger.info("Start vertx http server");
            httpServer = vertx.createHttpServer();
            Router router = deployVerticle();
            httpServer.requestHandler(router).listen(Integer.parseInt(Optional.ofNullable(port).orElse("8080")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        try {
            logger.info("Stop vertx http server");
            httpServer.close();
        } catch (Exception e) {
            logger.error("Vertx error", e);
        }
    }
}
