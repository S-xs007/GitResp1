package com.dragon.设计问题.手写日志框架.filter;


import com.dragon.设计问题.手写日志框架.LifeCycle;
import com.dragon.设计问题.手写日志框架.LoggingEvent;

public interface Filter extends LifeCycle {
    boolean doFilter(LoggingEvent event);
}
