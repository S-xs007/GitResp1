package com.造轮子.日志框架.layout.pattern;

import cc.leevi.common.logc.LoggingEvent;

public class MessageConverter extends KeywordConverter {
    @Override
    public String convert(LoggingEvent e) {
        return String.valueOf(e.getMessage());
    }
}
