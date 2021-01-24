package com.造轮子.日志框架.layout.pattern;

import cc.leevi.common.logc.LoggingEvent;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateConverter extends KeywordConverter {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    private SimpleDateFormat sdf = new SimpleDateFormat();

    @Override
    public String convert(LoggingEvent e) {
        return dateTimeFormatter.format(Instant.ofEpochMilli((e.getTimestamp())).atZone(ZoneId.systemDefault()).toLocalDateTime());
    }
}
