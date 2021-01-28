package com.dragon.多线程与高并发.Future的使用;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author coder01
 */
public interface Future<V> {
    /**
     * 取消
     * @param mayInterruptIfRunning
     * @return
     */
    boolean cancel(boolean mayInterruptIfRunning);
    /**
     * 是否取消
     * @return
     */
    boolean isCancelled();
    /**
     * 是否完成
     * @return
     */
    boolean isDone();
    /**
     * 获得返回值，该方法会一直阻塞
     */
    V get() throws InterruptedException, ExecutionException;
    /**
     * 带有超时时间的获取返回值
     * @param timeout
     * @param unit
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TimeoutException
     */
    V get(long timeout, TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException;
}
