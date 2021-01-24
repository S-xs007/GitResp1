package com.dragon.设计问题.手写日志框架.layout;


import com.dragon.设计问题.手写日志框架.LoggingEvent;

/**
 * 纯文本布局，直接调用{@link cc.leevi.common.logc.LoggingEvent#toString()}
 */
public class PlainLayout implements Layout {

    @Override
    public String doLayout(LoggingEvent e) {
        return e.toString();
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
