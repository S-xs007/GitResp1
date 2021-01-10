package com.algorithms4.字符串;

public class 判断是否为字符串重拍 {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length())return false;
        int[] visited = new int[26];
        for(int i = 0;i<s1.length();i++){
            visited[s1.charAt(i)-'a']++;
            visited[s2.charAt(i)-'a']--;
        }

        for(int i : visited){
            if(i != 0)return false;
        }
        return true;
    }
}
