package com.dragon.多线程问题.交替打印foo和bar;

import java.util.concurrent.Semaphore;

public class 信号量 {
    /**
     * 信号量
     */
    class FooBar2 {
        private int n;
        private Semaphore fooSemaphore = new Semaphore(1);
        private Semaphore barSemaphore = new Semaphore(0);

        public FooBar2(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                fooSemaphore.acquire();
                printFoo.run();
                barSemaphore.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                barSemaphore.acquire();
                printBar.run();
                fooSemaphore.release();
            }
        }
    }
}
