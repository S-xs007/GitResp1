package com.dragon.多线程与高并发.多线程问题.打印H2O;

import java.util.concurrent.Semaphore;

public class Lock_Condition01 {
}
//调用两次hydrogen 然后调用一次oxygen
class H2O {
    Semaphore semaphore = new Semaphore(0);
    Semaphore help = new Semaphore(2);
    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        help.acquire(1);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        semaphore.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphore.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        help.release(2);
    }
}