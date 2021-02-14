package com.dragon.网络编程.URL;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author coder01
 * equals方法可能师阻塞式io，避免存放在依赖这个方法的容器中（hashmap），最好用uri替代
 * URL还有一个方法sameFile，判断是否指向同一个资源，但是不比较片段标识符
 * toExternalForm返回值可以直接用于浏览器  toURI
 */
public class URLEquality {
    public static void main (String[] args) {
        try {
            URL www = new URL ("http://www.ibiblio.org/");
            URL ibiblio = new URL("http://ibiblio.org/");
            if (ibiblio.equals(www)) {
                System.out.println(ibiblio + " is the same as " + www);
            } else {
                System.out.println(ibiblio + " is not the same as " + www);
            }
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        }
    }
}
