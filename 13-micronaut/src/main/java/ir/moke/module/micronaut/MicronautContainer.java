package ir.moke.module.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

public class MicronautContainer {

    public static final MicronautContainer instance = new MicronautContainer();
    private static ApplicationContext applicationContext;

    private MicronautContainer() {
    }

    public void start() {
        applicationContext = Micronaut.run(MicronautContainer.class);
    }

    public void stop() {
        applicationContext.stop();
    }
}