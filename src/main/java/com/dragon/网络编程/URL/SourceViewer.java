package com.dragon.网络编程.URL;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
//下载一个web界面
//2.也可以使用getContent的方式，他回去寻找Content-type字段，但这只适用于文本和图像，视频啥的无法判断
public class SourceViewer {
    public static void main (String[] args) {

        if (args.length > 0) {
            InputStream in = null;
            try {
                // Open the URL for reading
                URL u = new URL(args[0]);
                in = u.openStream();
                // buffer the input to increase performance
                in = new BufferedInputStream(in);
                // chain the InputStream to a Reader
                Reader r = new InputStreamReader(in);
                int c;
                while ((c = r.read()) != -1) {
                    System.out.print((char) c);
                }
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            } catch (IOException ex) {
                System.err.println(ex);
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        // ignore
                    }
                }
            }
        }
    }
}
