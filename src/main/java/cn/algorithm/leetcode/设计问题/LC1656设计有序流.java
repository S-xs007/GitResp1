package cn.algorithm.leetcode.设计问题;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LC1656设计有序流 {
}
class OrderedStream {
    int size = 0;
    int cur = 1;
    int capacity = 0;
    Map<Integer,String> map = new HashMap<>();
    public OrderedStream(int n) {
        this.capacity = n;
    }

    public List<String> insert(int id, String value) {
        if(size+1>capacity)throw new RuntimeException("越界了");
        map.put(id,value);
        size++;
        List<String> list = new LinkedList<>();
        if(id == cur){
            while(map.containsKey(cur)){
                list.add(map.get(cur));
                cur++;
            }
        }
        return list;
    }
}