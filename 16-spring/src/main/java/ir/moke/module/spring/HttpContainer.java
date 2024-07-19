package ir.moke.module.spring;

import ir.moke.module.spring.config.AppConfig;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class HttpContainer {
    public static final HttpContainer instance = new HttpContainer();
    private static final Logger logger = LoggerFactory.getLogger(HttpContainer.class);
    private static final String host = System.getenv("HTTP_SERVER_HOST");
    private static final String port = System.getenv("HTTP_SERVER_PORT");
    private static final String contextPath = "";
    private static final String baseDir = "/tmp/tomcat";
    private static Tomcat tomcat;
    private static Connector connector;

    private HttpContainer() {
        createAppBaseDirectory();
    }

    private static void init() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);

        tomcat = new Tomcat();
        tomcat.setBaseDir(baseDir);
        tomcat.setHostname(Optional.ofNullable(host).orElse("0.0.0.0"));
        tomcat.setPort(Integer.parseInt(Optional.ofNullable(port).orElse("8080")));
        connector = tomcat.getConnector();
        Context tomcatContext = tomcat.addContext(contextPath, baseDir);

//        // Add Spring's DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        Tomcat.addServlet(tomcatContext, "dispatcher", dispatcherServlet);
//        tomcatContext.addServletMappingDecoded("/*", "dispatcher");
        tomcatContext.addServletMappingDecoded("/*", "dispatcher");
    }

    public void start() {
        try {
            init();
            tomcat.start();
            tomcat.getService().addConnector(connector);
            logger.info("Tomcat server started");
            tomcat.getServer().await();
        } catch (Exception e) {
            logger.error("Tomcat error", e);
        }
    }

    public void stop() {
        try (Stream<Path> pathStream = Files.walk(Path.of(baseDir))) {
            connector.stop();
            tomcat.getService().removeConnector(connector);
            tomcat.stop();
            tomcat.destroy();

            pathStream.sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(java.io.File::delete);
            logger.info("Tomcat server stopped");
        } catch (Exception e) {
            logger.error("Tomcat error", e);
        }
    }

    private void createAppBaseDirectory() {
        try {
            Path appBasePath = Path.of(baseDir);
            if (!Files.exists(appBasePath)) {
                Files.createDirectory(appBasePath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
