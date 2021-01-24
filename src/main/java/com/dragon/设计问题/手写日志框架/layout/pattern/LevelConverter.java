package com.dragon.设计问题.手写日志框架.layout.pattern;


import com.dragon.设计问题.手写日志框架.LoggingEvent;

public class LevelConverter implements Converter {

    @Override
    public String convert(LoggingEvent e) {
        return e.getLevel().toString();
    }

}