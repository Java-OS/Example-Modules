package ir.moke.module.quartz;

import ir.moke.jos.api.IModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleRunner implements IModule {
    private static final Logger logger = LoggerFactory.getLogger(ModuleRunner.class);

    @Override
    public void start() {
        logger.info("Start module");
        SchedulerService.instance.start();
    }

    @Override
    public void stop() {
        logger.info("Stop module");
        SchedulerService.instance.stop();
    }
}
