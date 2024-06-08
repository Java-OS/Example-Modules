package ir.moke.module.basic;

import ir.moke.jos.api.IModule;

public class ModuleRunner implements IModule {
    private static boolean enable = false;

    @Override
    public void start() {
        enable = true;
        LogService.generateLog(enable);
    }

    @Override
    public void stop() {
        enable = false;
    }
}
