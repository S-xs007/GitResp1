package com.dragon.设计问题.手写日志框架.filter;


import com.dragon.设计问题.手写日志框架.Level;
import com.dragon.设计问题.手写日志框架.LoggingEvent;

public class LevelFilter implements Filter{

    private String level;

    private Level l;

    @Override
    public boolean doFilter(LoggingEvent event) {
        return event.getLevel().isGreaterOrEqual(l);
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public void start() {
        this.l = Level.parse(level);
    }

    @Override
    public void stop() {

    }
}
