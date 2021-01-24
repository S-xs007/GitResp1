package com.造轮子.日志框架.layout;

import cc.leevi.common.logc.LifeCycle;
import cc.leevi.common.logc.LoggingEvent;

public interface Layout extends LifeCycle {
    String doLayout(LoggingEvent e);
}
