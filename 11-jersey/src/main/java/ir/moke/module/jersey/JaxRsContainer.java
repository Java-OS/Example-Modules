package ir.moke.module.jersey;

import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import ir.moke.module.jersey.resource.PersonResources;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;

public class JaxRsContainer {
    public static final JaxRsContainer instance = new JaxRsContainer();
    private static final Logger logger = LoggerFactory.getLogger(JaxRsContainer.class);
    private static HttpServer httpServer;

    private JaxRsContainer() {

    }

    public void start() {
        JacksonJsonProvider provider = new JacksonJsonProvider();

        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(provider);
        resourceConfig.register(PersonResources.class);
        httpServer = GrizzlyHttpServerFactory.createHttpServer(URI.create("http://0.0.0.0:8080"), resourceConfig);
        try {
            logger.error("Start grizzly http server");
            httpServer.start();
        } catch (IOException e) {
            logger.error("Grizzly http server error", e);
        }
    }

    public void stop() {
        logger.error("Stop grizzly http server");
        httpServer.shutdownNow();
    }
}
