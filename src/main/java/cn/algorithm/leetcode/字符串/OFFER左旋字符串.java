package cn.algorithm.leetcode.字符串;

import com.sun.org.apache.bcel.internal.generic.FSUB;

public class OFFER左旋字符串 {
    public String reverseLeftWords(String s, int n) {
        if(n>s.length()||s.length()==0||s==null||n==0)return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n,s.length()));
        sb.append(s.substring(0,n));
        return sb.toString();
    }
}
