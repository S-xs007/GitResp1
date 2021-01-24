package com.dragon.设计问题.LRU缓存;

import java.util.concurrent.TimeUnit;

/**
 * @author coder01
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        LRUCache cache = new LRUCache(200);
        for(int i = 0;i<Integer.MAX_VALUE;i++){
            cache.put(new Integer(i),new Reference());
            TimeUnit.SECONDS.sleep(1);
            System.out.println("现在是第"+i+"个");
        }

    }
}
