package com.多线程与高并发.多线程问题.交替打印数字和字母;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class TransferQueue1 {
    public static void main(String[] args) {
        char[] ss = "123456789".toCharArray();
        char[]  zz = "ABCDEFGHI".toCharArray();
        //阻塞队列
        TransferQueue transferQueue = new LinkedTransferQueue();
        new Thread(()->{
            for(char s1:ss){
                try {
                    transferQueue.transfer(s1);
                    System.out.print(transferQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"t1").start();

        new Thread(()->{
            for(char z1:zz){
                try {
                    System.out.print(transferQueue.take());
                    transferQueue.transfer(z1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"t2").start();
    }
}
