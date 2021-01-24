package com.dragon.对象的排序.map;

import java.util.*;

/**
 * TreeMap按key排序
 */
public class TreeMapSort {
    public static void main(String[] args) {
        //Treemap初始化传入一个外置的比较器（如果不加这个外置的比较器就是默认升序）
        Map<String, String> map = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        // 降序排序
                        return obj2.compareTo(obj1);
                    }
                });
        map.put("c", "ccccc");
        map.put("a", "aaaaa");
        map.put("b", "bbbbb");
        map.put("d", "ddddd");

        //TreeMap的key变成集合
        Set<String> keySet = map.keySet();
        //获得这个集合的迭代器
        Iterator<String> iter = keySet.iterator();
        //遍历集合（从而实现排序）
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key + ":" + map.get(key));
        }
    }
}
