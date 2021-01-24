package com.dragon.设计问题.手写日志框架.layout.pattern;


import com.dragon.设计问题.手写日志框架.LoggingEvent;

public class LineSeparatorConverter extends KeywordConverter {
    @Override
    public String convert(LoggingEvent e) {
        return System.lineSeparator();
    }
}
