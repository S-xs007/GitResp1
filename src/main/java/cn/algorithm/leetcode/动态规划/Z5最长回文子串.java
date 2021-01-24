package cn.algorithm.leetcode.动态规划;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Z5最长回文子串 {
    //构成最长的回文串（简单）
    public int longestPalindrome2(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char tem:s.toCharArray()){
            map.put(tem,map.getOrDefault(tem,0)+1);
        }
        int sum = 0;
        boolean flag = true;
        for(char tem:map.keySet()){
            int num = map.get(tem);
            if(num % 2 == 0){   //偶数直接构造
                sum += num;
            }else{
                if(num -1>0){   //奇数减去一个然后构造
                    sum+= num-1;
                }
            }
            if(flag && num%2!=0){   //可以多用一个奇数作为中心
                sum++;
                flag = false;
            }
        }
        return sum;
    }


    /**
     * 中心扩散算法
      * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for(int i = 0;i<s.length();i++){   //对每一个点进行中心扩散
            int len1 = expandAroundCenter(s, i, i);             //奇数类型
            int len2 = expandAroundCenter(s, i, i + 1);    //偶数类型
            int len = Math.max(len1, len2);
            if (len > end - start) {    //如果这次的结果大于之前的长度，就更新新的位置
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }
        return s.substring(start, end + 1);
    }
    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}
