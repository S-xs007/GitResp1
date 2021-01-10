package cn.bzqz.leetcode.数组;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LC无重复数字的最长子串 {
    //暴力
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.equals(""))return 0;
        char[] nums = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int res = 0;
        for(int i = 0;i<s.length();i++){
            for(int j = i;j<s.length();j++){
                if(!set.contains(nums[j])){
                    set.add(nums[j]);
                    res = Math.max(res,set.size());
                }

                else {
                    res = Math.max(res,set.size());
                    set = new HashSet<>();
                    break;
                }
            }
        }

        return res;
    }
    //滑动窗口
    public int lengthOfLongestSubstring1(String s) {
        if(s.length() == 0 || s.equals(""))return 0;
        char[] nums = s.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        int res = 0;
        for(char num:nums){
            if(!deque.contains(num)){
                deque.offerLast(num);
                res = Math.max(deque.size(),res);
            }else {
                while(!deque.isEmpty() && deque.contains(num)){
                    deque.pollFirst();
                }
                deque.offerLast(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = " ";
        LC无重复数字的最长子串 lc无重复数字的最长子串 = new LC无重复数字的最长子串();
        lc无重复数字的最长子串.lengthOfLongestSubstring(s);
    }
}
