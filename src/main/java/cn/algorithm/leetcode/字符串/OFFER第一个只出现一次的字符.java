package cn.algorithm.leetcode.字符串;

import java.util.*;

public class OFFER第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        Map<Character,Boolean> map = new HashMap<>();
        for(char tem:s.toCharArray()){
            map.put(tem, !map.containsKey(tem));
        }
        for(char tem:s.toCharArray()){
            if(map.get(tem)){
                return tem;
            }
        }
        return ' ';
    }
    //利用LinkedHashMap有序哈希表
    public char firstUniqChar1(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }
    }

