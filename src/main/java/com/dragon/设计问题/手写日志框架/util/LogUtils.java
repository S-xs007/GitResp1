package com.dragon.设计问题.手写日志框架.util;

public class LogUtils {

    private static final String LOG_PREFIX = "logc: ";

    public static void info(String msg) {
        System.out.println(LOG_PREFIX + msg);
    }

    public static void error(String msg, Throwable t) {
        System.err.println(LOG_PREFIX + msg);
        if(t != null){
            System.err.println(LOG_PREFIX + t.getMessage());
        }
    }

    public static void error(String msg) {
        error(msg, null);
    }

}
