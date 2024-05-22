package com.sample.module;

import ir.moke.jos.api.JModule;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ModuleRunner implements JModule {
    private static final ExecutorService es = Executors.newVirtualThreadPerTaskExecutor();

    @Override
    public void start() {
        LogService.generateLog(es);
    }

    /**
     * Always should stop threads when module stopped
     */
    @Override
    public void stop() {
        es.shutdown();
    }
}
