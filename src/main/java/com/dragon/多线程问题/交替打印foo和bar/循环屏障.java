package com.dragon.多线程问题.交替打印foo和bar;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class 循环屏障 {

    /**
     * 通过循环屏障
     */
    class FooBar1 {
        private int n;

        public FooBar1(int n) {
            this.n = n;
        }

        CyclicBarrier cb = new CyclicBarrier(2);
        volatile boolean fin = true;

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while(!fin);
                printFoo.run();
                fin = false;
                try {
                    cb.await();
                } catch (BrokenBarrierException e) {
                }
            }
        }
        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                try {
                    cb.await();
                } catch (BrokenBarrierException e) {
                }
                printBar.run();
                fin = true;
            }
        }
    }
}
