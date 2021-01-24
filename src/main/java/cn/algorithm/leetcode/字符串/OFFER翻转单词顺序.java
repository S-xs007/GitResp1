package cn.algorithm.leetcode.字符串;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class OFFER翻转单词顺序 {
    //从后往前双指针
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

    public String reverseWords1(String s) {
       String[] tem = s.trim().split(" ");
       StringBuilder sb = new StringBuilder();
       for(int i = tem.length-1;i>=0;i--){
           if(tem[i].equals("")){
               continue;
           }
           sb.append(tem[i]+" ");
       }
       return sb.toString().trim();
    }
}
