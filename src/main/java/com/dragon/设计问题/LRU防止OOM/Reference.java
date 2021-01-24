package com.dragon.设计问题.LRU防止OOM;

/**
 * 引用
 */
public class Reference {
    /**
     * 1MB
     */
    private final byte[] data = new byte[1024 * 1024];

    @Override
    protected void finalize() throws Throwable {
        System.out.println(" the reference will be gc");
    }
}
