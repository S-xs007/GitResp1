package 蜻蜓笔试;

import java.util.HashMap;
import java.util.Map;
//核心思路
//使用双向链表来判断元素的使用顺序，如果，最近使用的放在队列头部，最晚使用的放在队列的尾部
public class LRUcache {
    class DLinkedList{  //自定义双端链表
        DLinkedList pre;
        DLinkedList next;
        int key;
        int value;
        DLinkedList(int _key,int _value){
            key = _key;
            value = _value;
        }
        DLinkedList(){}
    }
    Map<Integer,DLinkedList> cache = new HashMap<>();
    DLinkedList head = new DLinkedList();   //虚拟头节点
    DLinkedList tail = new DLinkedList();   //虚拟尾节点点
    int size;
    int capacity;
    public LRUcache(int k){  //初始化
        this.capacity = k;
        size = 0;
        head = tail;
        tail = head;
    }

    public void set(int key,int value){
        DLinkedList node = cache.get(key);
        if(node == null){   //不存在就直接插入到链表头部，然后放到缓存中
            DLinkedList temNode = new DLinkedList(key,value);
            addToHead(temNode);
            cache.put(key,temNode);
            size++;
            if(size>capacity){
                //删除队列的尾节点
                removeTail();
                size--;
            }
        }else{              //存在就要进行覆盖，然后一定到队列的头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void removeTail() { //删除尾节点
        tail.pre.pre.next = tail.pre.next;
        tail.pre = tail.pre.pre;
    }

    public int get(int key){
        DLinkedList node = cache.get(key);
        if(node == null){
            throw new RuntimeException("key 不存在");
        }else {
            int value = node.value;
            moveToHead(node);   //把该节点移动到链表头部
            return value;
        }
    }

    private void moveToHead(DLinkedList node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedList node) {
        node.pre = head;
        node.next = head.next;
        head.next = node;
        node.next.pre = node;
    }

    private void removeNode(DLinkedList node) { //删除节点
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


}


