package com.造轮子.日志框架.appender;

import java.io.IOException;
import java.io.OutputStream;

public class ConsoleAppender extends AppenderBase {
    private OutputStream out = System.out;
    private OutputStream out_err = System.err;

    @Override
    protected void doAppend(String body) {
        try {
            out.write(body.getBytes(encoding));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
