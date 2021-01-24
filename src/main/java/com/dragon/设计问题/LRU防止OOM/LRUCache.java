package com.dragon.设计问题.LRU防止OOM;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author coder01
 */
public class LRUCache<K,V> {

    private final LinkedList<K> linkedList = new LinkedList<>();
    /**
     * LRU缓存
     */
    private final Map<K, SoftReference<V>> cache = new HashMap<>();
    private final int CAPACITY;
    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
    }
    public void put(K k,V v){
        if(cache.size() >= CAPACITY){
            K val = linkedList.removeFirst();
            cache.remove(val);
        }

        if(!cache.containsKey(k)){
            linkedList.addLast(k);
        }else {
            linkedList.remove(k);
            linkedList.addLast(k);
        }
        cache.put(k,new SoftReference<>(v));
    }
    public V get(K k){
        SoftReference<V> res =  cache.get(k);
        if(res != null){
            linkedList.remove(k);
            linkedList.addLast(k);
            return res.get();
        }
        return null;
    }
}
