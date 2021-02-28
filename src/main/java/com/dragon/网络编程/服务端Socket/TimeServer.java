package com.dragon.网络编程.服务端Socket;

import java.io.*;
import java.net.*;
import java.util.Date;

/**
 * 该服务器返回自 GMT 1900 年 1 月 1 日 12：00 AM 以后的秒数
 * Date是1970之后 ，需要转化
 */
public class TimeServer {

    public final static int PORT = 37;

    public static void main(String[] args) {

        long differenceBetweenEpochs = 2208988800L;

        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try (Socket connection = server.accept()) {
                    OutputStream out = connection.getOutputStream();
                    Date now = new Date();
                    long msSince1970 = now.getTime();
                    long secondsSince1970 = msSince1970/1000;
                    long secondsSince1900 = secondsSince1970
                            + differenceBetweenEpochs;
                    byte[] time = new byte[4];
                    //转化为 32 位无符号整数（java没有提供）
                    //25-32 位
                    time[0]
                            = (byte) ((secondsSince1900 & 0x00000000FF000000L) >> 24);
                    //17 - 24位
                    time[1]
                            = (byte) ((secondsSince1900 & 0x0000000000FF0000L) >> 16);
                    // 9- 16 位
                    time[2]
                            = (byte) ((secondsSince1900 & 0x000000000000FF00L) >> 8);
                    //得到低8位
                    time[3] = (byte) (secondsSince1900 & 0x00000000000000FFL);
                    out.write(time);
                    out.flush();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}