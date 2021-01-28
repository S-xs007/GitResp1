package com.dragon.多线程与高并发.线程交替打印.并发包juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueue<T>{
    private Object[] items;
    private int addIndex,removeIndex,count;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public BoundedQueue(int size){
        this.items = new Object[size];
    }

    public void add(T t){
        lock.lock();
        try{
           while (count==items.length){
               //满了
               notFull.await();
           }
           items[addIndex] = t;
           if(++addIndex == items.length){
               addIndex = 0;
           }
           ++count;
           notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T remove() throws InterruptedException {
        lock.lock();;
        try{
            while (count==0){
                notEmpty.await();
            }
            Object o = items[removeIndex];
            if(++removeIndex == items.length){
                removeIndex = 0;
                count--;    //删除之后容量--
                notFull.signal();   //唤醒生产添加线程
                return (T) o;
            }
        } finally {
            lock.unlock();
        }
        return null;
    }
}
