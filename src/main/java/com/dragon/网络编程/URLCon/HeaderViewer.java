package com.dragon.网络编程.URLCon;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 % java HeaderViewer http://oreilly.com.favicon.ico
 Content-type: image/x-icon
 Date: Fri May 31 18:16:01 EDT 2013
 Last modified: Wed Mar 26 19:14:36 EST 2003
 Expiration date: Fri Jun 07 18:16:01 EDT 2013
 Contend-length: 2298
 */
public class HeaderViewer {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                URL u = new URL(args[0]);
                URLConnection uc = u.openConnection();
                System.out.println("Content-type: " + uc.getContentType());
                if (uc.getContentEncoding() != null) {
                    System.out.println("Content-encoding: "
                            + uc.getContentEncoding());
                    //等同于  String encoding = uc.getHeaderField("content-encoding");
                    }
                    Date now = new Date(uc.getHeaderFieldDate("date",0));  //发送时间（格林尼治到现在毫秒数），默认0
                    //等同于  String date = uc.getHeaderField("date");
                    Date last = new Date(uc.getHeaderFieldDate("last-modified",0));  //最后修改时间（格林尼治到现在毫秒数），默认0
                    //等同于  String last = uc.getHeaderField("last-modified");
                    Date expires = new Date(uc.getHeaderFieldDate("expires",0));   //过期时间（格林尼治到现在毫秒数），默认0
                    int contentLength = uc.getHeaderFieldInt("content-length",-1); //内容长度（发送二进制文件一定要提供这个字段）

            } catch (MalformedURLException ex) {
                System.err.println(args[i] + " is not a URL I understand");
            } catch (IOException ex) {
                System.err.println(ex);
            }
            System.out.println();
        }
    }
}
