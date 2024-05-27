package ir.moke.module.camel;

import org.apache.camel.main.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CamelContainer {
    public static final CamelContainer instance = new CamelContainer();
    private static final Logger logger = LoggerFactory.getLogger(CamelContainer.class);
    private static final Main main = new Main(CamelContainer.class);

    private CamelContainer() {
    }

    public void start() {
        try {
            logger.info("Start apache camel");
            main.run();
        } catch (Exception e) {
            logger.error("Failed to run camel", e);
        }
    }


    public void stop() {
        logger.info("Stop apache camel");
        main.stop();
    }
}
