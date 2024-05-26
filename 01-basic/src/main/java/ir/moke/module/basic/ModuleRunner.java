package ir.moke.module.basic;

import ir.moke.jos.api.IModule;

public class ModuleRunner implements IModule {

    @Override
    public void start() {
        LogService.generateLog();
    }

    @Override
    public void stop() {
        // In this module is not usable !
    }
}
