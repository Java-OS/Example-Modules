package ir.moke.module.timer;

import ir.moke.jos.api.IModule;

import java.util.Timer;

public class ModuleRunner implements IModule {
    private static final TaskService taskService = new TaskService();
    private static Timer timer;

    @Override
    public void start() {
        timer = new Timer("jos time module");
        timer.scheduleAtFixedRate(taskService, 1000, 3000);
    }

    @Override
    public void stop() {
        timer.cancel();
    }
}
