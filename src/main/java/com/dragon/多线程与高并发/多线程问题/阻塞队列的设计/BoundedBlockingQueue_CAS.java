package com.dragon.多线程与高并发.多线程问题.阻塞队列的设计;

import java.util.Deque;
import java.util.LinkedList;

public class BoundedBlockingQueue_CAS {
    Deque<Integer> deque;
    volatile int size = 0;
    int capacity = 0;
    public BoundedBlockingQueue_CAS(int capacity) {
        this.capacity = capacity;
        deque = new LinkedList<>();
    }

    //队首添加
    public void enqueue(int element) throws InterruptedException {
       while(size==capacity){
           //自选
       }
       size++;
       deque.offerLast(element);
    }

    public int dequeue() throws InterruptedException {
        while(size==0){
        //自旋
        }
        size--;
        return deque.pollFirst();
    }

    public int size() {
        return size;
    }
}
