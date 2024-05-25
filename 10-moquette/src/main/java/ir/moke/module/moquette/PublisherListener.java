package ir.moke.module.moquette;

import io.moquette.interception.AbstractInterceptHandler;
import io.moquette.interception.messages.InterceptPublishMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

public class PublisherListener extends AbstractInterceptHandler {
    private static final Logger logger = LoggerFactory.getLogger(PublisherListener.class);

    @Override
    public String getID() {
        return "EmbeddedLauncherPublishListener";
    }

    @Override
    public void onPublish(InterceptPublishMessage msg) {
        final String decodedPayload = msg.getPayload().toString(StandardCharsets.UTF_8);
        logger.info("Received on topic: {} content: {}", msg.getTopicName(), decodedPayload);
    }

    @Override
    public void onSessionLoopError(Throwable throwable) {
        logger.info("Session event loop reported error: {}", throwable.getMessage(), throwable);
    }
}
