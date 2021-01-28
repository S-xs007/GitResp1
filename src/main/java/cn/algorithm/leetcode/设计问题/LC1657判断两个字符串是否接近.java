package cn.algorithm.leetcode.设计问题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC1657判断两个字符串是否接近 {
    public boolean closeStrings(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        if(s1.length!=s2.length)return false;   //长度相同
        for(char ss:s1){
            map.put(ss,map.getOrDefault(ss,0)+1);
        }
        for(char ss:s2){
            if(!map.containsKey(ss)){
                return false;   //元素种类相同
            }
            map2.put(ss,map2.getOrDefault(ss,0)+1);
        }
        for(char tem:map.keySet()){
            if(!map2.containsKey(tem))return false; //两个map种类相同
        }
        for(char tem:map.keySet()){
            set.add(map.get(tem));
        }
        for(char tem:map2.keySet()){
            if(!set.contains(map2.get(tem)))return false;   //个数相同
        }
        return true;
    }
}
