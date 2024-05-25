package ir.moke.module.moquette;

import io.moquette.broker.config.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class ModuleResourceLoader extends ClasspathResourceLoader {
    private static final Logger logger = LoggerFactory.getLogger(ModuleResourceLoader.class);

    public ModuleResourceLoader(String defaultResource) {
        super(defaultResource);
    }

    public Reader loadResource(String relativePath) {
        logger.info("Loading resource. RelativePath = {}.", relativePath);
        InputStream is = getClass().getResourceAsStream(relativePath);
        return is != null ? new InputStreamReader(is, StandardCharsets.UTF_8) : null;
    }
}
