package com.dragon.NIO;

import java.net.*;
import java.util.Enumeration;
import java.util.List;

public class NetworkInterface01 {
    public static void main(String[] args) throws SocketException, UnknownHostException {


        //还有三个静态方法
        NetworkInterface byIndex = NetworkInterface.getByIndex(1);  //获取指定索引的网络接口
        NetworkInterface lo = NetworkInterface.getByName("lo");     //根据名字
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        NetworkInterface byInetAddress = NetworkInterface.getByInetAddress(inetAddress);//根据IP地址

        Enumeration<NetworkInterface> network = NetworkInterface.getNetworkInterfaces();//返回此机器上所有网络接口
        while (network.hasMoreElements()) {
            NetworkInterface networkInterface = network.nextElement();
            System.out.println("获取网络设备名称" + networkInterface.getName());
            System.out.println("获取网络设备显示名称" + networkInterface.getDisplayName());
            System.out.println("获取网络接口的索引" + networkInterface.getIndex());
            System.out.println("是否已经开启并运行" + networkInterface.isUp());
            System.out.println("是否为回调接口" + networkInterface.isLoopback());
            System.out.println("获取数据包的最大传输单元" + networkInterface.getMTU());
            System.out.println("获取MAC地址" + networkInterface.getHardwareAddress());
            System.out.println("是不是点对点设备" + networkInterface.isPointToPoint());
            System.out.println("是否支持多地址广播" + networkInterface.supportsMulticast());
            //
            List<InterfaceAddress> interfaceAddresses = networkInterface.getInterfaceAddresses();


            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                System.out.println("IP地址的全限定域名" + inetAddresses.nextElement().getCanonicalHostName());
                System.out.println("IP地址的字符串" + inetAddresses.nextElement().getHostAddress());
                System.out.println("IP地址的主机名" + inetAddresses.nextElement().getHostName());
                byte[] address = inetAddresses.nextElement().getAddress();//原始ip地址
            }
            //子接口只有linux支持
            //获取父接口
            networkInterface.getParent();
            //获取子接口
            Enumeration<NetworkInterface> subInterfaces = networkInterface.getSubInterfaces();
            while (subInterfaces.hasMoreElements()) {
                System.out.println("获取网络设备显示名称" + networkInterface.getDisplayName());
            }
            System.out.println("是否为虚拟接口" + networkInterface.isVirtual());
            System.out.println();
        }
    }
}

