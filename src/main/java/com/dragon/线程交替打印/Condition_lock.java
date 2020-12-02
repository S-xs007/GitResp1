package com.dragon.线程交替打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Condition_lock {
    public static void main(String[] args) {
        char[] ss = "123456789".toCharArray();
        char[]  zz = "ABCDEFGHI".toCharArray();
        Lock lock = new ReentrantLock();
        //两个队列，唤醒会非常精准，t1就在condition1里面等待和被唤醒，t2就在condition2里面等待或被唤醒
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        new Thread(()->{
            lock.lock();
            try {
                for (char s1 : ss) {
                    System.out.print(s1);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            }catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

        },"t1").start();

        new Thread(()->{
            lock.lock();
            try {
                for (char z1 : zz) {
                    System.out.print(z1);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        },"t2").start();

    }
}
