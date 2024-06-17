package ir.moke.module.jersey.common;

import org.glassfish.jersey.server.ResourceConfig;

public class ResourceConfigProvider {
    public static final ResourceConfigProvider instance = new ResourceConfigProvider();
    private static final ResourceConfig resourceConfig = new ResourceConfig();

    private ResourceConfigProvider() {
    }

    public ResourceConfig getResourceConfig() {
        return resourceConfig;
    }

    public void register(Class<?> clazz) {
        if (!resourceConfig.isRegistered(clazz)) {
            resourceConfig.register(clazz);
        }
    }

    public void register(Object component) {
        if (!resourceConfig.isRegistered(component)) {
            resourceConfig.register(component);
        }
    }

    public void unregister(Class<?> clazz) {
        resourceConfig.getResources();
    }
}
