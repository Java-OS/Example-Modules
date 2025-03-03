package ir.moke.module.basic;

import ir.moke.jos.api.IModule;

import java.util.Timer;

public class ModuleRunner implements IModule {

    private Timer timer;

    @Override
    public void start() {
        LogService logService = new LogService();
        this.timer = new Timer("Log Service");
        timer.scheduleAtFixedRate(logService, 1000, 1000);
    }

    @Override
    public void stop() {
        timer.cancel();
    }
}
