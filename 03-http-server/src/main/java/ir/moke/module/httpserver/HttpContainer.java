package ir.moke.module.httpserver;

import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.Optional;

public class HttpContainer {
    public static final HttpContainer instance = new HttpContainer();
    private static final Logger logger = LoggerFactory.getLogger(HttpContainer.class);
    private static final String host = System.getenv("HTTP_SERVER_HOST");
    private static final String port = System.getenv("HTTP_SERVER_PORT");
    private HttpServer httpServer;

    private HttpContainer() {
        try {
            InetSocketAddress inetSocketAddress = new InetSocketAddress(
                    Optional.ofNullable(host).orElse("0.0.0.0"),
                    Integer.parseInt(Optional.ofNullable(port).orElse("8080"))
            );
            httpServer = HttpServer.create(inetSocketAddress, -1);
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
