package com.dragon.设计问题.手写日志框架.layout.pattern;


import com.dragon.设计问题.手写日志框架.LoggingEvent;

public interface Converter {

    String convert(LoggingEvent e);

}
