package cn.algorithm.leetcode.递归;

import java.util.Arrays;

public class LC反转字符串 {
    public void reverseString2(char[] s) {
        helper(0, s.length - 1, s);
    }

    private void helper(int start, int end, char [] s) {
        if (start >= end) {
            return;
        }
        // swap between the first and the last elements.
        char tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;

        helper(start + 1, end - 1, s);
    }
}
