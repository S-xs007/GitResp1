package com.dragon.设计问题.手写日志框架.layout.pattern;



import com.dragon.设计问题.手写日志框架.LoggingEvent;

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
