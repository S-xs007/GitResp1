package com.dragon.多线程与高并发.多线程问题.交替打印数字和字母;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_Condition01 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        AtomicBoolean flag = new AtomicBoolean(false);
        char[] ss = "123456789".toCharArray();
        char[]  zz = "ABCDEFGHI".toCharArray();
        new Thread(()->{
            lock.lock();
            try{
                for(int i = 0;i<ss.length;i++){
                    System.out.println(ss[i]);
                    flag.set(true);
                    conditionB.signal();
                    conditionA.await();
                }
                conditionB.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }).start();


        new Thread(()->{
            lock.lock();
            try{
                if(!flag.get()){
                    conditionB.await();
                }
                for(int i = 0;i<zz.length;i++){
                    System.out.println(zz[i]);
                    conditionA.signal();
                    conditionB.await();
                }
                conditionA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }).start();
    }

}
