package com.造轮子.日志框架.layout.pattern;

import cc.leevi.common.logc.LoggingEvent;

public class LevelConverter implements Converter {

    @Override
    public String convert(LoggingEvent e) {
        return e.getLevel().toString();
    }

}