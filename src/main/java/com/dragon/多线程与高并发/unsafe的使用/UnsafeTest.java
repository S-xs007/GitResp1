package com.dragon.多线程与高并发.unsafe的使用;

import java.util.concurrent.FutureTask;

public class UnsafeTest {

    /**
     * 下面是利用unsafe获取类字段的偏移量
     */
    private static final sun.misc.Unsafe UNSAFE;
    private static final long stateOffset;
    private static final long runnerOffset;
    private static final long waitersOffset;
    static {
        try {
            UNSAFE = sun.misc.Unsafe.getUnsafe();
            Class<?> k = FutureTask.class;
            stateOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("state"));
            runnerOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("runner"));
            waitersOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("waiters"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public void cas() {
        //利用cas来替换值
        Boolean isSuccess = UNSAFE.compareAndSwapInt(this, stateOffset, 0, 2);
    }


}
