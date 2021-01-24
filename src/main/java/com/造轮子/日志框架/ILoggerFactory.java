package com.造轮子.日志框架;

public interface ILoggerFactory {
    Logger getLogger(Class<?> clazz);

    Logger getLogger(String name);

    Logger newLogger(String name);
}
