package ir.moke.module.jersey.hello;

import ir.moke.jos.api.IModule;
import ir.moke.module.jersey.common.ResourceConfigProvider;

public class ModuleRunner implements IModule {
    @Override
    public void start() {
        ResourceConfigProvider.instance.register(HelloResource.class);
    }

    @Override
    public void stop() {
        ResourceConfigProvider.instance.unregister(HelloResource.class);
    }
}
