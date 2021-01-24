package com.dragon.多线程与高并发.多线程问题.阻塞队列的设计;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition freeCond = lock.newCondition();
    private final Condition elemCond = lock.newCondition();
    private final Deque<Integer> que = new LinkedList<>();
    private final int capacity;

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (que.size() == capacity) {
                freeCond.await();
            }
            que.offerLast(element);
            elemCond.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (que.size() == 0) {
                elemCond.await();
            }
            int val = que.pollFirst();
            freeCond.signal();
            return val;
        } finally {
            lock.unlock();
        }
    }

    public synchronized int size() {
        lock.lock();
        try {
            return que.size();
        } finally {
            lock.unlock();
        }
    }
}
