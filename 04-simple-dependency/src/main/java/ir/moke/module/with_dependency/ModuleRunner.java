package ir.moke.module.with_dependency;

import ir.moke.jos.api.JModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleRunner implements JModule {
    private static final Logger logger = LoggerFactory.getLogger(ModuleRunner.class);

    @Override
    public void start() {
        logger.info("Start http server");
        HttpContainer.instance.start();
    }

    @Override
    public void stop() {
        logger.info("Stop http server");
        HttpContainer.instance.stop();
    }
}
