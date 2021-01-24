package com.造轮子.日志框架.filter;

import cc.leevi.common.logc.LifeCycle;
import cc.leevi.common.logc.LoggingEvent;

public interface Filter extends LifeCycle {
    boolean doFilter(LoggingEvent event);
}
