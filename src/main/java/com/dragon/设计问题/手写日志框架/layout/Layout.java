package com.dragon.设计问题.手写日志框架.layout;


import com.dragon.设计问题.手写日志框架.LifeCycle;
import com.dragon.设计问题.手写日志框架.LoggingEvent;

public interface Layout extends LifeCycle {
    String doLayout(LoggingEvent e);
}
