package com.dragon.设计问题.手写日志框架.appender;


import com.dragon.设计问题.手写日志框架.LifeCycle;
import com.dragon.设计问题.手写日志框架.LoggingEvent;

public interface Appender extends LifeCycle {

    String getName();

    void setName(String name);

    void append(LoggingEvent e);
}
