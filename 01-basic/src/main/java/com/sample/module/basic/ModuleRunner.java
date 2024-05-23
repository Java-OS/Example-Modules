package com.sample.module.basic;

import ir.moke.jos.api.JModule;

public class ModuleRunner implements JModule {

    @Override
    public void start() {
        LogService.generateLog();
    }

    @Override
    public void stop() {
        // In this module is not usable !
    }
}
