package com.dragon.多线程与高并发.多线程问题.交替打印数字和字母;

import java.util.concurrent.locks.LockSupport;

/**
 * 两个线程交替打印
 */
public class LockSupport01 {
    static Thread t1,t2;
    public static void main(String[] args) {
        char[] ss = "123456789".toCharArray();
        char[]  zz = "ABCDEFGHI".toCharArray();
        t1 = new Thread(() -> {
            for (char s1 : ss) {
                System.out.print(s1);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        },"t1");
        t2 = new Thread(()->{
            for(char z1:zz){
                LockSupport.park();
                System.out.print(z1);
                LockSupport.unpark(t1);
            }
        },"t2");
        t1.start();
        t2.start();
    }

}
