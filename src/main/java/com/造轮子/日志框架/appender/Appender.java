package com.造轮子.日志框架.appender;

import cc.leevi.common.logc.LifeCycle;
import cc.leevi.common.logc.LoggingEvent;

public interface Appender extends LifeCycle {

    String getName();

    void setName(String name);

    void append(LoggingEvent e);
}
