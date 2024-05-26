package ir.moke.module.moquette;

import ir.moke.jos.api.IModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleRunner implements IModule {
    private static final Logger logger = LoggerFactory.getLogger(ModuleRunner.class);

    @Override
    public void start() {
        logger.info("Start module");
        BrokerContainer.instance.start();
    }

    @Override
    public void stop() {
        logger.info("Stop module");
        BrokerContainer.instance.stop();
    }
}
