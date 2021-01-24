package com.造轮子.日志框架;

public class LoggerFactory {

    private static ILoggerFactory loggerFactory = new StaticLoggerFactory();

    public static ILoggerFactory getLoggerFactory(){
        return loggerFactory;
    }

    public static Logger getLogger(Class<?> clazz){
        return getLoggerFactory().getLogger(clazz);
    }

    public static Logger getLogger(String name){
        return getLoggerFactory().getLogger(name);
    }

}
