package com.dragon.网络编程.HTTPUrlCon;

import java.io.*;
import java.net.*;

/**
 * 如果连接出错打印错误信息
 */
public class SourceViewer4 {

    public static void main (String[] args) {
        try {
            URL u = new URL(args[0]);
            HttpURLConnection uc = (HttpURLConnection) u.openConnection();
            try (InputStream raw = uc.getInputStream()) {
                printFromStream(raw);
            } catch (IOException ex) {
                printFromStream(uc.getErrorStream());
            }
        } catch (MalformedURLException ex) {
            System.err.println(args[0] + " is not a parseable URL");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private static void printFromStream(InputStream raw) throws IOException {
        try (InputStream buffer = new BufferedInputStream(raw)) {
            Reader reader = new InputStreamReader(buffer);
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        }
    }
}