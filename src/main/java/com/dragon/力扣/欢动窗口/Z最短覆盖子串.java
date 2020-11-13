package com.dragon.力扣.欢动窗口;

import java.util.*;

public class Z最短覆盖子串 {
    Map<Character, Integer> ttt = new HashMap<Character, Integer>();    //保存s数组出现的字符极其个数
    Map<Character, Integer> sss = new HashMap<Character, Integer>();    //保存t数组出现的字符极其个数

    public String minWindow(String s, String t) {
        //把t中的元素保存到map中
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ttt.put(c, ttt.getOrDefault(c, 0) + 1);
        }
        //窗口左边界和有边界
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;      //保存目标字符串的左右边界
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ttt.containsKey(s.charAt(r))) {     //没走完，并且ttt中有r位置的字符，就放到sss的map中
                sss.put(s.charAt(r), sss.getOrDefault(s.charAt(r), 0) + 1);
            }   //开始检查，如果sss包含了ttt那么就开始从左往右走
            while (check() && l <= r) {     //
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ttt.containsKey(s.charAt(l))) { //去除重复的
                    sss.put(s.charAt(l), sss.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ttt.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (sss.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    //最短的字串覆盖
    public String minWindow(String s, String t) {
        int[] window = new int[128], need = new int[128];
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        int count = 0, min = ss.length;
        String res = "";
        for (int i = 0; i < tt.length; i++) {
            need[tt[i]]++;
        }
        int i = 0, j = 0;
        while(j < ss.length) {
            char c = ss[j];
            window[c]++;
            if (window[c] <= need[c]) count++;
            while(count == tt.length) {     //全部字符都找到了
                if (j - i + 1 <= min){      //更新最短子串
                    res = s.substring(i, j + 1);
                    min = j - i + 1;
                }
                window[ss[i]]--;
                if (window[ss[i]] < need[ss[i]]) count--;
                i++;    //向左走
                if (i >= ss.length) break;
            }
            j++;    //往右走
        }
        return res;
    }
}
   