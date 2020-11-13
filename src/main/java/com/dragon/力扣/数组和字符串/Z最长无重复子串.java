package com.dragon.力扣.数组和字符串;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class Z最长无重复子串 {

    /**
     * 滑动窗口
     * 利用set保存窗口内的字符
     * 然后每次左指针右移一次，然后右指针开始找结束位置更新最大不重复子串的长度
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int len = s.length();
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<Character>();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for(int i = 0;i<len;i++){

            if(i!=0)set.remove(s.charAt(i-1));//做指针享有移动

            while(rk+1<len&&!set.contains(s.charAt(rk+1))){
                set.add(s.charAt(rk+1));
                rk++;
            }
            ans = Math.max(ans,set.size());
        }
        return ans;
    }
}
