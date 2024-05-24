package ir.moke.module.tomcat;

import ir.moke.module.tomcat.servlet.HelloServlet;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.TomcatURLStreamHandlerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class HttpContainer {
    public static final HttpContainer instance = new HttpContainer();
    private static final Logger logger = LoggerFactory.getLogger(HttpContainer.class);
    private static final String contextPath = "/app";
    private static final String host = System.getenv("HTTP_SERVER_HOST");
    private static final String port = System.getenv("HTTP_SERVER_PORT");
    private static final String appBase = "/tmp/tomcat";
    private static Tomcat tomcat;

    private HttpContainer() {
        createAppBaseDirectory();
        TomcatURLStreamHandlerFactory.disable();
        tomcat = new Tomcat();
        tomcat.setHostname(Optional.ofNullable(host).orElse("0.0.0.0"));
        tomcat.setPort(Integer.parseInt(Optional.ofNullable(port).orElse("8080")));
        tomcat.setBaseDir(appBase);

        Context context = tomcat.addWebapp(contextPath, appBase);

        tomcat.addServlet(contextPath, "hello", new HelloServlet());
        context.addServletMappingDecoded("/hello", "hello");
    }

    private static void createAppBaseDirectory() {
        try {
            Path appBasePath = Path.of(appBase);
            if (!Files.exists(appBasePath)) {
                Files.createDirectory(appBasePath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {
        try {
            tomcat.getConnector();
            tomcat.start();
            logger.info("Tomcat server started");
            tomcat.getServer().await();
        } catch (Exception e) {
            logger.error("Tomcat error", e);
        }
    }

    public void stop() {
        try (Stream<Path> pathStream = Files.walk(Path.of(appBase))) {
            pathStream.sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(java.io.File::delete);

            tomcat.stop();
            logger.info("Tomcat server stopped");
        } catch (Exception e) {
            logger.error("Tomcat error", e);
        }
    }
}
