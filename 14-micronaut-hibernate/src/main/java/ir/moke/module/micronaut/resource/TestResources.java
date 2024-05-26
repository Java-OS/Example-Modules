package ir.moke.module.micronaut.resource;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/test")
public class TestResources {
    private static final Logger logger = LoggerFactory.getLogger(TestResources.class);

    @Get("/hello")
    public String sayHello() {
        logger.info("Request sayHello()");
        return "Hello dear !";
    }

    @Get("/bye")
    public String sayBye() {
        logger.info("Request sayBye()");
        return "Bye bye !";
    }
}
