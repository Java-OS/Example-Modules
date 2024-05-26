package ir.moke.module.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.runtime.Micronaut;
import jakarta.persistence.Entity;

@Introspected(packages = "ir.moke.module.micronaut.entity", includedAnnotations = Entity.class)
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