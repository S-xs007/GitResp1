package com.dragon.对象的排序.map;

import java.util.*;

/**
 * HashMap按key或balue排序
 */
public class TreeMapSort02 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("d", "d");
        map.put("b", "c");
        map.put("a", "b");
        map.put("c", "a");

        //key-value放在entry然后放在list中
        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                //这里getKey就是对key排序，getValue就是对value排序
                //正着写就是升序，反这些就是降序
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for(Map.Entry<String,String> mapping:list){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }
}
