package ir.moke.module.spring;

import ir.moke.jos.api.IModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ModuleRunner implements IModule {
    private static final Logger logger = LoggerFactory.getLogger(ModuleRunner.class);
    private static final Properties sysProps = System.getProperties();

    @Override
    public void start() {
        /*
         * Only for bypass FUCKING org.apache.catalina.loader.WebappClassLoaderBase#clearReferencesJdbc
         * somebody tell to tomcat team fix this fucking NPE bug .
         * */
        sysProps.setProperty("org.graalvm.nativeimage.imagecode", "runtime");
        logger.info("Start module");
        HttpContainer.instance.start();
    }

    @Override
    public void stop() {
        logger.info("Stop module");
        HttpContainer.instance.stop();
        sysProps.remove("org.graalvm.nativeimage.imagecode");
    }
}
