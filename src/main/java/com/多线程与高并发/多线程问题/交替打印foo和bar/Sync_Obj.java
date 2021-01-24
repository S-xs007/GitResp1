package com.多线程与高并发.多线程问题.交替打印foo和bar;

import java.util.concurrent.CountDownLatch;

public class Sync_Obj {
    /**
     * synchronized+屏障
     */
    class FooBar {
        private int n;
        CountDownLatch latch = new CountDownLatch(1);
        Object lock = new Object();
        public FooBar(int n) {
            this.n = n;
        }
        public void foo(Runnable printFoo) throws InterruptedException {
            synchronized(lock){
                for (int i = 0; i < n; i++) {
                    printFoo.run();
                    latch.countDown();
                    lock.notifyAll();
                    lock.wait();
                }
                lock.notify();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            synchronized(lock){
                for (int i = 0; i < n; i++) {
                    latch.await();
                    printBar.run();
                    lock.notifyAll();
                    lock.wait();
                }
                lock.notify();
            }
        }
    }

}
