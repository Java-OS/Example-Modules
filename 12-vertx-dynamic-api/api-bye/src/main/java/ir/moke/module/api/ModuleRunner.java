package ir.moke.module.api;

import ir.moke.jos.api.IModule;
import ir.moke.module.vertx.common.ApplicationVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleRunner implements IModule {
    private static final Logger logger = LoggerFactory.getLogger(ModuleRunner.class);

    @Override
    public void start() {
        logger.info("Start module");
        ApplicationVerticle.instance.registerRoute(byeRoute::handle, byeRoute.ROUTE_NAME, byeRoute.ROUTE_PATH);
    }

    @Override
    public void stop() {
        logger.info("Stop module");
        ApplicationVerticle.instance.removeRouteByName(byeRoute.ROUTE_NAME);
    }
}
