package ir.moke.module.jetty;

import ir.moke.module.jetty.servlet.HelloServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class HttpContainer {
    public static final HttpContainer instance = new HttpContainer();
    private static final Logger logger = LoggerFactory.getLogger(HttpContainer.class);
    private static final String port = System.getenv("HTTP_SERVER_PORT");
    private static Server server;

    private HttpContainer() {
        server = new Server(Integer.parseInt(Optional.ofNullable(port).orElse("8080")));
        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(HelloServlet.class, "/*");
        server.setHandler(handler);
    }

    public void start() {
        try {
            server.start();
            logger.info("Jetty server started");
            server.join();
        } catch (Exception e) {
            logger.error("Jetty error", e);
        }
    }

    public void stop() {
        try {
            server.stop();
            logger.info("Jetty server stopped");
        } catch (Exception e) {
            logger.error("Jetty error", e);
        }
    }
}
