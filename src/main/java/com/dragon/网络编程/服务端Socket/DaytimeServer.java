package com.dragon.网络编程.服务端Socket;

import java.net.*;
import java.io.*;
import java.util.Date;

public class DaytimeServer {
    //linux上13端口需要root权限  或者修改端口>1024
    public final static int PORT = 13;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try (Socket connection = server.accept()) {
                    Writer out = new OutputStreamWriter(connection.getOutputStream());
                    //每当有客户端连接到这个服务器，就会返回一这个当前时间
                    Date now = new Date();
                    //一定要以 "\r\n" 结束
                    out.write(now.toString() +"\r\n");
                    out.flush();
                    connection.close();
                } catch (IOException ex) {}
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}