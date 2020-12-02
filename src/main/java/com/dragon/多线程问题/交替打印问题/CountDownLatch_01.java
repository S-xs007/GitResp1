package com.dragon.多线程问题.交替打印问题;

import java.util.concurrent.CountDownLatch;

class Foo2 {

    CountDownLatch countDownLatch12, countDownLatch23;

    public Foo2() {
        countDownLatch12 = new CountDownLatch(1);
        countDownLatch23 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatch12.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        //等待计数器归零再向下执行
        countDownLatch12.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatch23.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        //等待计数器归零再向下执行
        countDownLatch23.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

public class CountDownLatch_01 {
}
