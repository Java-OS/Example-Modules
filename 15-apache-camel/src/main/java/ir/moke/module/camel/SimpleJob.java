package ir.moke.module.camel;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class SimpleJob extends RouteBuilder {
    private static final Logger logger = LoggerFactory.getLogger(SimpleJob.class);

    private static void process(Exchange p) {
        p.getMessage().setBody(LocalDateTime.now() + "  Executed");
    }

    @Override
    public void configure() throws Exception {
        from("timer:sample?period=1000")
                .process(SimpleJob::process)
                .process(item -> logger.info(item.getMessage().getBody().toString()))
                .log("Completed");
    }
}
