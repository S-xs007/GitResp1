package com.多线程与高并发.多线程问题.交替打印foo和bar;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_Condition {
    /**
     * lock+condition
     */
    class FooBar {
        private int n;
        private ReentrantLock lock = new ReentrantLock();
        private Condition fooCondition = lock.newCondition();
        private Condition barCondition = lock.newCondition();
        boolean flag = false;
        public FooBar(int n) {
            this.n = n;
        }
        public void foo(Runnable printFoo) throws InterruptedException {
            try{
                lock.lock();
                for (int i = 0; i < n; i++) {
                    printFoo.run();
                    flag = true;
                    barCondition.signal();
                    fooCondition.await();
                }
                barCondition.signal();  //不写是出不了循环的
            }finally {
                lock.unlock();
            }
        }
        public void bar(Runnable printBar) throws InterruptedException {
            try{
                lock.lock();
                for (int i = 0; i < n; i++) {
                    if (!flag) {
                        barCondition.await();
                    }
                    printBar.run();
                    fooCondition.signal();
                    barCondition.await();
                }
                fooCondition.signal();
            }finally {
                lock.unlock();
            }
        }
    }
}

