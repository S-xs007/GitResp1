package com.dragon.设计问题.手写日志框架.config;


import com.dragon.设计问题.手写日志框架.LoggerContext;

import java.net.URL;

public class YAMLConfigurator implements Configurator{

    private final URL url;

    private final LoggerContext loggerContext;

    public YAMLConfigurator(URL url, LoggerContext loggerContext) {
        this.url = url;
        this.loggerContext = loggerContext;
    }

    @Override
    public void doConfigure() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
