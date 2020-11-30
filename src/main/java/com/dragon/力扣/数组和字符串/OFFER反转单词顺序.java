package com.dragon.力扣.数组和字符串;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class OFFER反转单词顺序 {
    //双指针
    public String reverseWords(String s) {
        String tmp = s.trim();
        int start = tmp.length() - 1;
        int end = tmp.length() - 1;
        String res = "";
        while(start >= 0) {
            while(start >= 0 && tmp.charAt(start) != ' ') {
                start--;
            }
            res += tmp.substring(start + 1, end + 1) + " ";
            while(start >= 0 && tmp.charAt(start) == ' ') {
                start--;
            }
            end = start;
        }
        return res.trim();
    }
}
