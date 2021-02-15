package com.dragon.网络编程.URLCon;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
/**
 * 通过URLConnection下载URL对应的数据
 * URLConnection和URL最大的不同是，URLConnection允许访问HTTP头部，配置请求参数，给服务器发送到数据
 */

public class SourceViewer2 {

    public static void main (String[] args) {
        if  (args.length > 0) {
            try {
                // open the URLConnection for reading
                URL u = new URL(args[0]);
                URLConnection uc = u.openConnection();
                try (InputStream raw = uc.getInputStream()) {
                    InputStream buffer = new BufferedInputStream(raw);
                    // chain the InputStream to a Reader
                    Reader reader = new InputStreamReader(buffer);
                    int c;
                    while ((c = reader.read()) != -1) {
                        System.out.print((char) c);
                    }
                }
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
