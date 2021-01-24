package com.多线程与高并发.多线程问题.交替打印数字和字母;

import java.util.concurrent.CountDownLatch;
//syc参数：可以显式的定义一把锁，也可以锁this，但在静态方法内需要锁.class
public class Syc_notify_wite {
    //初始化门栓为一，为了保证t1线程先执行
    private static CountDownLatch latch = new CountDownLatch(1);
    public static void main(String[] args) {
        //显式的定义一把锁，因为syc是把对象当成锁
        final Object o = new Object();
        char[] ss = "123456789".toCharArray();
        char[]  zz = "ABCDEFGHI".toCharArray();
        new Thread(()->{
            synchronized (o){
                for(char s1:ss){
                    System.out.print(s1);
                    //门栓-1，为零就会打开
                    latch.countDown();
                        o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //停止线程
                o.notify();
            }

        },"t1").start();
        new Thread(()->{

                //如果第二个线程先进来，会被门栓阻塞
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (o){
                for(char z1:zz){
                    System.out.print(z1);
                        o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //停止线程,这个可以不写，因为肯定最后是t2线程打印完最后一个字母之后wite，然后需要被t1叫醒
               // o.notify();
            }

        },"t2").start();
    }
}
