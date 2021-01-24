package com.dragon.设计问题.手写日志框架.layout.pattern;


import com.dragon.设计问题.手写日志框架.LoggingEvent;

public class LiteralConverter implements Converter {

    private String literal;

    @Override
    public String convert(LoggingEvent e) {
        return literal;
    }

    public LiteralConverter(String literal) {
        this.literal = literal;
    }
}
