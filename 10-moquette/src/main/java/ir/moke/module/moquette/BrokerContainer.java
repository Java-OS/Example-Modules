package ir.moke.module.moquette;

import io.moquette.broker.Server;
import io.moquette.broker.config.IConfig;
import io.moquette.broker.config.IResourceLoader;
import io.moquette.broker.config.ResourceLoaderConfig;
import io.moquette.interception.InterceptHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public class BrokerContainer {
    public static final BrokerContainer instance = new BrokerContainer();
    private static final Logger logger = LoggerFactory.getLogger(BrokerContainer.class);
    private static Server mqttBroker;

    public void start() {
        try {
            IResourceLoader classpathLoader = new ModuleResourceLoader("/moquette.conf");
            IConfig config = new ResourceLoaderConfig(classpathLoader);

            /*
             * You can change configuration:
             * config.setProperty();
             * */

            logger.info("Moquette server started");
            mqttBroker = new Server();
            List<? extends InterceptHandler> userHandlers = Collections.singletonList(new PublisherListener());
            mqttBroker.startServer(config, userHandlers);
        } catch (Exception e) {
            logger.error("Moquette Error", e);
        }
    }

    public void stop() {
        logger.info("Moquette server stopped");
        mqttBroker.stopServer();
    }
}
