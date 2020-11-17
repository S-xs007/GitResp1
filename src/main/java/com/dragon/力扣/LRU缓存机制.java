package com.dragon.力扣;

import java.util.HashMap;
import java.util.Map;

/**
 * 11-13 中午1次
 */
public class LRU缓存机制 {
}
class LRUCache {
    class DLinkedNode { //双向链表 ，节点保存key和value
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();  //map --key  链表节点
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 1.先从map中看看有没有
     * 2.将该节点移动到链表头节点处（LRU算法就是使用的越多越不容易删除）
     * @param key
     * @return
     */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    /**
     * 1.先看map中有没有，有的话就修改node的value，然后移动到头部
     * 2.没有的话就创建一个节点封装kv，然后放到hash中，头插法 在判断是不是超越对打容量了
     *      超过了就删除链表尾的节点，然后从map中清除
     *      没超过就结束
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }


    //头插法
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    //删除双端链表的节点
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    //当前节点移动到头部（删除当前节点，然后头插法）
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }
    //删除尾戒点的前一个节点
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }




















































}

