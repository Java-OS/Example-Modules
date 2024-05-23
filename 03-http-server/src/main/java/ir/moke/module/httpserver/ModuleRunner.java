package ir.moke.module.httpserver;

import ir.moke.jos.api.JModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleRunner implements JModule {
    private static final Logger logger = LoggerFactory.getLogger(ModuleRunner.class);
    private static HttpContainer httpContainer;

    public ModuleRunner() {
        try {
            String host = System.getenv("HTTP_SERVER_HOST");
            int port = Integer.parseInt(System.getenv("HTTP_SERVER_PORT"));
            httpContainer = new HttpContainer(host, port);
        } catch (Exception e) {
            logger.error("Unknown error", e);
        }
    }

    @Override
    public void start() {
        httpContainer.start();
    }

    @Override
    public void stop() {
        httpContainer.start();
    }
}
