package ir.moke.module.httpserver;

import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

public class HttpContainer {
    public static final HttpContainer instance = new HttpContainer();
    private static final Logger logger = LoggerFactory.getLogger(HttpContainer.class);
    private HttpServer httpServer;
    private HttpContainer() {
        try {
            String host = System.getenv("HTTP_SERVER_HOST");
            int port = Integer.parseInt(System.getenv("HTTP_SERVER_PORT"));
            httpServer = HttpServer.create(new InetSocketAddress(host, port), -1);
        } catch (Exception e) {
            logger.error("Http container error", e);
        }
    }

    public void start() {
        httpServer.createContext("/hello", new HelloApi());
        httpServer.start();
    }

    public void stop() {
        httpServer.stop(1);
    }
}
