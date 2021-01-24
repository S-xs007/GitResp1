package com.dragon.设计问题.手写日志框架;

/**
 * logger接口
 */
public interface Logger{
    void trace(String msg);

    void info(String msg);

    void debug(String msg);

    void warn(String msg);

    void error(String msg);

    String getName();
}
