package cn.algorithm.leetcode.动态规划;

import java.util.*;

public class LC重复的DNA序列PASS {
    //方案1 放到map中，value存储出现的次数，然后遍历key，value》1的就是目标
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if(s.length()<=10)return list;
        HashMap<String,Integer> map=  new HashMap<>();
        for(int i = 9;i<s.length();i++){
            String x = s.substring(i-9,i+1);
            map.put(x,map.getOrDefault(x,0)+1);
        }
        Set<String> tem = map.keySet();
        for(String x:tem){
            if(map.get(x)>1){
                list.add(x);
            }
        }
        return list;

    }

    //利用set不重复的特性
    public List<String> findRepeatedDnaSequences1(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> re = new HashSet<>();
        for(int i = 9;i<s.length();i++){
            String x = s.substring(i-9,i+1);
            if(seen.contains(x))re.add(x);
            seen.add(x);
        }
        return new ArrayList<>(re);
    }
}
