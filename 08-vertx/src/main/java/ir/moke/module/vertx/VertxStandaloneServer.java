package ir.moke.module.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class VertxStandaloneServer {
    public static final VertxStandaloneServer instance = new VertxStandaloneServer();
    private static final Logger logger = LoggerFactory.getLogger(VertxStandaloneServer.class);
    private static final String port = System.getenv("VERTX_HTTP_PORT");
    private static final Vertx vertx = Vertx.vertx();
    private static HttpServer httpServer;

    private VertxStandaloneServer() {
    }

    private static Router deployVerticle() {
        ApplicationVerticle applicationVerticle = new ApplicationVerticle();
        vertx.deployVerticle(applicationVerticle);
        return applicationVerticle.getRouter();
    }

    public void start() {
        try {
            logger.info("Vertx server started");
            httpServer = vertx.createHttpServer();
            Router router = deployVerticle();
            httpServer.requestHandler(router).listen(Integer.parseInt(Optional.ofNullable(port).orElse("8080")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
