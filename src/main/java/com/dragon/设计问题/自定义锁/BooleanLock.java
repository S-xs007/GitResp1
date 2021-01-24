package com.dragon.设计问题.自定义锁;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

public class BooleanLock implements Lock{
    //当前拥有锁的线程
    private Thread currentThread;

    private Boolean locked = false;

    private final List<Thread> blockedList = new ArrayList<>();

    @Override
    public void lock() throws InterruptedException {
        //当前锁已经被其他线程得到，则当前线程进入阻塞队列
        synchronized (this){
            final Thread cur = Thread.currentThread();
            while(locked){
                try{
                    if(!blockedList.contains(cur)){
                        blockedList.add(cur);
                    }
                    this.wait();
                }catch (InterruptedException e){
                    //被中断之后防止内存泄漏
                    if(blockedList.contains(cur)){
                        blockedList.remove(cur);
                    }
                    throw new InterruptedException("currentThread is interrupted");
                }
            }
            blockedList.remove(cur);
            this.locked = true;
            this.currentThread = cur;
        }

    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this){
            Thread cur = Thread.currentThread();
            //时间设置的不合理
            if(mills < 0){
                throw new RuntimeException("mills must >  0");
            } else {
                long remainingMills = mills;
                long endMills = System.currentTimeMillis()+remainingMills;
                //只要锁已经被抢占了，就一直更新更新剩余时间
                while (locked){
                    if(remainingMills <= 0){
                        throw new TimeoutException("can not get the lock during " + mills + "ms." );
                    }
                    if(!blockedList.contains(cur)){
                        blockedList.add(cur);
                    }
                    this.wait(remainingMills);
                    remainingMills = endMills - System.currentTimeMillis();
                }
                //锁被释放了，且推出了循环，说明没有超时，则设置当前线程抢占了锁
                blockedList.remove(cur);
                this.locked = true;
                this.currentThread = cur;
            }
        }
    }

    @Override
    public void unlock() {
        //释放锁的时候，判断当前线程是不是获得锁的线程
        synchronized (this){
            if (currentThread == Thread.currentThread()){
                this.locked = false;
                Optional.of(Thread.currentThread().getName() + " release the lock," ).ifPresent(System.out::println);
                //锁释放了之后需要唤醒所有阻塞的线程
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blockedList);
    }
}
