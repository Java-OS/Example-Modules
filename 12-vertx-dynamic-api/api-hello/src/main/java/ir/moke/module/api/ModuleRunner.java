package ir.moke.module.api;

import ir.moke.jos.api.IModule;
import ir.moke.module.common.ApplicationVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleRunner implements IModule {
    private static final Logger logger = LoggerFactory.getLogger(ModuleRunner.class);

    @Override
    public void start() {
        logger.info("Start module");
        ApplicationVerticle.instance.registerRoute(HelloRoute::handle, HelloRoute.ROUTE_NAME, HelloRoute.ROUTE_PATH);
    }

    @Override
    public void stop() {
        logger.info("Stop module");
        ApplicationVerticle.instance.removeRouteByName(HelloRoute.ROUTE_NAME);
    }
}
