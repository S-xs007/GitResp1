package com.dragon.网络编程.URL;


import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author coder01
 * URL类提供了URL组成部分的只读访问方法
 * URL主要利用从服务器下载资源
 */
public class URL_demo {
    //url格式：protocol://userInfo@host:port/path?query#fragment
    //  protocol  协议：ftp http https file telnet magnet
    //  host      主机名或ip地址
    //  port      http默认80端口可省略
    //  fragment  片段表示符

    /*相对URL
    http://www.jd.com/book.html  点击  <a href="food.html">  就会跳转到  http://www.jd.com/food.html*/

    /*绝对URL
    http://www.jd.com/book/book01.html  点击  <a href="/food.html">  就会跳转到  http://www.jd.com/food.html*/

    //URL类是一个final类，同String，为了支持不同协议的URL使用了策略模式，URL作为上下文维护了协议处理器
    //可以使用URL类创建不存在或者不允许连接的主机的URL

    //RMI和JDBC是由java.rmi和java.sql支持的,很奇怪
    public static void main(String[] args) {
        // hypertext transfer protocol
        testProtocol("http://www.adc.org");
        // secure http
        testProtocol("https://www.amazon.com/exec/obidos/order2/");
        // file transfer protocol
        testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq/");
        // Simple Mail Transfer Protocol
        testProtocol("mailto:elharo@ibiblio.org");
        // telnet
        testProtocol("telnet://dibner.poly.edu/");
        // local file access
        testProtocol("file:///etc/passwd");
        // gopher
        testProtocol("gopher://gopher.anc.org.za/");
        // Lightweight Directory Access Protocol
        testProtocol(
                "ldap://ldap.itd.umich.edu/o=University%20of%20Michigan,c=US?postalAddress");
        // JAR
        testProtocol(
                "jar:http://cafeaulait.org/books/javaio/ioexamples/javaio.jar!"
                        + "/com/macfaq/io/StreamCopier.class");
        // NFS, Network File System
        testProtocol("nfs://utopia.poly.edu/usr/tmp/");
        // a custom protocol for JDBC
        testProtocol("jdbc:mysql://luna.ibiblio.org:3306/NEWS");
        // rmi, a custom protocol for remote method invocation
        testProtocol("rmi://ibiblio.org/RenderEngine");
        // custom protocols for HotJava
        testProtocol("doc:/UsersGuide/release.html");
        testProtocol("netdoc:/UsersGuide/release.html");
        testProtocol("systemresource://www.adc.org/+/index.html");
        testProtocol("verbatim:http://www.adc.org/");
    }

    private static void testProtocol(String url) {
        try {
            URL u = new URL(url);
            System.out.println(u.getProtocol() + " is supported");
            //URL url1 = new URL("http","www.jd.com","/book.html"); 使用协议默认地址
            //构造相对URL
            /*URL url1 = new URL("http://www.jd.com/book/java.html");
            URL url2 = new URL(url1,"tea.html");*/
        } catch (MalformedURLException ex) {
            String protocol = url.substring(0, url.indexOf(':'));
            System.out.println(protocol + " is not supported");
        }
    }
}

