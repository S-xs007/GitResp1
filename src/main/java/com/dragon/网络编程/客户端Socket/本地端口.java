package com.dragon.网络编程.客户端Socket;

import java.io.IOException;
import java.net.*;
import java.nio.channels.SocketChannel;

public class 本地端口 {
    public static void main(String[] args) {
        //获取远程主机和端口，以及本地主机和端口
        for (String host : args) {
            try {
                Socket theSocket = new Socket(host, 80);
                System.out.println("Connected to " + theSocket.getInetAddress()
                        + " on port "  + theSocket.getPort() + " from port "
                        + theSocket.getLocalPort() + " of "
                        + theSocket.getLocalAddress());
            }  catch (UnknownHostException ex) {
                System.err.println("I can't find " + host);
            } catch (SocketException ex) {
                System.err.println("Could not connect to " + host);
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
        try{
            InetAddress inward = InetAddress.getByName("router");
            //本地端口选择 为 1024 - 65535 之间的可用端口
            //这样构造就会开通一个连接
            Socket socket = new Socket("mail",25,inward,0);
            //下面这样写会显示的进行连接
            //SocketAddress这个对象主要用于存储这些信息，以便于关闭连接之后可以继续重用，具体可以存储什么可以看构造函数
            /*Socket socket1 = new Socket();
            SocketAddress address = new InetSocketAddress("time.nist.gov",13);
            socket.connect(address，15000);*/
            //使用代理服务器，我们可以设置完全绕开代理服务器，前提是目标服务器的防火墙允许
            SocketAddress proxyAddress = new InetSocketAddress("myproxy.emample.com",1080);
            Proxy proxy = new Proxy(Proxy.Type.SOCKS,proxyAddress);
            Socket s = new Socket(proxy);
            SocketAddress remote = new InetSocketAddress("login.ibiblio.org",25);
            //设置属性
            s.setTcpNoDelay(true);  //打破缓冲，包就绪就发送，无需缓冲更大的包（服务器捕捉客户端鼠标）
            if(s.getSoLinger() == -1){
                //close方法后4分钟内去发送尚未完成的包
                s.setSoLinger(true,240);
            }
            if(s.getSoTimeout() == 0){
                //read方法3分钟超时
                s.setSoTimeout(180000);
            }
            //最大带宽=缓冲区大小/延迟时间   （接受和发送缓冲区谨慎修改）

            //客户端使用空闲连接保持状态直到11分钟内服务器还没有响应
            s.setKeepAlive(true);
            //允许另一个socket绑定这个端口，即使此时仍有可能存在一个socket未接受的数据
            s.setReuseAddress(true);
            s.connect(remote);
        }catch (IOException e){

        }
    }
}
