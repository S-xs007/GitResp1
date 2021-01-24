package com.dragon.设计问题.手写日志框架;

public class ConfigException extends RuntimeException {
    public ConfigException(Exception e) {
        super(e);
    }

    public ConfigException(String message) {
        super(message);
    }
}
