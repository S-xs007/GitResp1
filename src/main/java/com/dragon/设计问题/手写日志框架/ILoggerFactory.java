package com.dragon.设计问题.手写日志框架;

public interface ILoggerFactory {
    Logger getLogger(Class<?> clazz);

    Logger getLogger(String name);

    Logger newLogger(String name);
}
