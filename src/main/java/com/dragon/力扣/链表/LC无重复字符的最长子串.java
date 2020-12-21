package com.dragon.力扣.链表;

import java.util.HashSet;
import java.util.Set;

public class LC无重复字符的最长子串 {
    //时间复杂度太低
    public static int lengthOfLongestSubstring(String s) {
        char[] ss = s.toCharArray();
        HashSet<HashSet<Character>> result = new HashSet<>();
        for(int i = 0;i<ss.length;i++){
            HashSet<Character> set = new HashSet<>();
            int j = i;
            while (j<ss.length){
                if(!set.contains(ss[j])){
                    set.add(ss[j]);
                }else {
                    j = ss.length+1;
                }
                j++;
            }
            result.add(set);
        }
        int max = 0;
        for(HashSet tem: result){
            max = Math.max(tem.size(),max);
        }
        return max;
    }
    //利用滑动窗口
    public int lengthOfLongestSubstring1(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        int right = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (right + 1 < n && !occ.contains(s.charAt(right + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(right + 1));
                ++right;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
