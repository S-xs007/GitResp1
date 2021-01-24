package com.dragon.设计问题.手写日志框架.config;


import com.dragon.设计问题.手写日志框架.LifeCycle;

public interface Configurator  extends LifeCycle {
    void doConfigure();
}
