package ir.moke.module.zeromq;

import ir.moke.jos.api.JModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleRunner implements JModule {
    private static final Logger logger = LoggerFactory.getLogger(ModuleRunner.class);

    @Override
    public void start() {
        logger.info("Start module");
        ZeroMQServer.instance.start();
    }

    @Override
    public void stop() {
        logger.info("Stop module");
        ZeroMQServer.instance.stop();
    }
}
