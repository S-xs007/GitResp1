package com.dragon.多线程与高并发.多线程问题.并发设计模式;

import java.util.LinkedList;

/**
 * @author coder01
 *
 */
public class GuardedSuspensionQueue {
    private final LinkedList<Integer> list = new LinkedList<>();
    private final static int LIMIT = 100;

    public void offer(Integer val) throws InterruptedException {
        synchronized (this){
            while(list.size() >= LIMIT){
                this.wait();
            }
            list.addLast(val);
            this.notifyAll();
        }
    }

    public Integer take() throws InterruptedException {
        synchronized (this){
            while(list.isEmpty()){
                this.wait();
            }
            this.notifyAll();
            return list.removeFirst();
        }
    }
}
