package cn.algorithm.leetcode.字符串;

import java.util.HashMap;
import java.util.HashSet;

public class W3无重复的最长子串 {
    /**
     * 总体思路：
     * 利用HashSet作为滑动窗口
     * 设置左右两个坐标，每次先把左边的一个移除，然后右边完后走，遇到重复，更新最大长度，然后左边继续移除一个-------
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> used = new HashSet<>();//保存已经出现的字符串
        int max = 0;
        int len = s.length();
        int right = -1; //滑动窗口的右指针
        for(int i = 0;i<len;i++){
           if(used.size()>0){    //如果set里面有值，就移除最左边的元素
               used.remove(s.charAt(i-1));
           }
           while(right+1<len&&!used.contains(s.charAt(right+1))){   //一直向右走，知道遇到重复
               used.add(s.charAt(right+1));
               right++;
           }
           max = Math.max(used.size(),max); //遇到重复开始更新最大值
        }
        return max;
    }
}
