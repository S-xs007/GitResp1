package com.dragon.设计问题.自定义锁;

import java.util.List;
import java.util.concurrent.TimeoutException;
/**
 * @Author: zxS
 * @Date: 9:52 2021/1/16
 * @Description：定义顶层接口
 */
public interface Lock {
    /**
     * 加锁，直到成功为止，可响应中断
     * @throws InterruptedException
     */
    void lock() throws InterruptedException;

    /**
     * 在给定时间内加锁，时间到了抛出异常
     * @param mills
     * @throws InterruptedException
     * @throws TimeoutException
     */
    void lock(long mills) throws InterruptedException, TimeoutException;

    /**
     * 解锁
     */
    void unlock();

    /**
     * 获得当前阻塞的线程
     * @return
     */
    List<Thread> getBlockedThreads();

}
