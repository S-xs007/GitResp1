package com.dragon.网络编程.URLCon;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 得到整个http首部（以下是jd的首部）
 Server: nginx
 Date: Tue, 16 Feb 2021 05:12:25 GMT
 Content-Type: text/html; charset=utf-8
 Content-Length: 113168
 Connection: keep-alive
 Cache-Control: max-age=30
 Expires: Tue, 16 Feb 2021 05:12:46 GMT
 Ser: 94.73
 Vary: Accept-Encoding
 Via: BJ-H-NX-114(HIT), http/1.1 ORI-CLOUD-HB-MIX-23 (jcs [cMsSfW]), http/1.1 DL-UNI-2-MIX-22 (jcs [cRs f ])
 X-Content-Type-Options: nosniff
 X-Frame-Options: SAMEORIGIN
 X-Xss-Protection: 1; mode=block
 Age: 2
 Access-Control-Allow-Origin: *
 Timing-Allow-Origin: *
 X-Trace: 200;200-1613452344966-0-0-0-20-20;200-1613452345006-0-0-0-50-50
 Strict-Transport-Security: max-age=360
 */
public class AllHeaders {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                URL u = new URL(args[i]);
                URLConnection uc = u.openConnection();
                for (int j = 1; ; j++) {
                    String header = uc.getHeaderField(j);
                    if (header == null) break;
                    System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
                }
            } catch (MalformedURLException ex) {
                System.err.println(args[i] + " is not a URL I understand.");
            } catch (IOException ex) {
                System.err.println(ex);
            }
            System.out.println();
        }
    }
}
