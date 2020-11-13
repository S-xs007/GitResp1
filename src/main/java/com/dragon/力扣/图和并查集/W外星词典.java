package com.dragon.力扣.图和并查集;

import java.util.*;

public class W外星词典 {
    public String alienOrder(String[] words) {
        HashMap<Character, Set<Character>> graph = new HashMap();           //图
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            // 这里改成这样就是为了防止 abc
            int len = Math.max(words[i].length(), words[i + 1].length());       //获得当前字符串和下一个字符串的最大长度

            for (int j = 0; j < len; j++) {
                // 这里是个坑 要防止 abc -> ab 这种情况
                if (j >= words[i].length()) break;
                if (j >= words[i+1].length()) return "";

                if (words[i].charAt(j) == words[i + 1].charAt(j)) {     //一个一个判断，直到不相同
                    continue;
                }
                Set<Character> set = graph.computeIfAbsent(words[i].charAt(j), k -> new HashSet<>());
                set.add(words[i + 1].charAt(j));
                graph.put(words[i].charAt(j), set);
                break;
            }
        }

        // --------------------------------------------------这一下是拓扑排序----------------------------

        LinkedList<Character> queue = new LinkedList();
        // 入度初始化
        int[] inDegree = new int[26];
        Arrays.fill(inDegree, -1);

        int numChar = 0;
        //遍历火星单词表
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree[c - 'a'] = 0;      //出现的字符入度初始化为0
            }
        }
        // 入度为0的先学习 想成一个课程表
        for (Character key : graph.keySet()) {
            for (Character value: graph.get(key)) {
                inDegree[value - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (inDegree[i] == 0) {
                queue.add((char) (i + 'a'));    //入度为0的先学习
            }
            if (inDegree[i] != -1) {
                numChar++;//有入度就++  边的个数
            }
        }

        while (!queue.isEmpty()) {
            Character firstChar = queue.poll();
            res.append(firstChar);      //弹出一个字符之后加入到结果集
            if (graph.containsKey(firstChar)) {
                for (Character nextChar : graph.get(firstChar)) {
                    inDegree[nextChar - 'a']--;
                    if (inDegree[nextChar - 'a'] == 0) {
                        queue.add(nextChar);
                    }
                }
            }
        }
        if (res.length() != numChar) {
            return "";
        }
        return res.toString();
    }
}

class C{
    public String alienOrder(String[] words) {
        HashMap<Character,Set<Character>> graph = new HashMap<>();     //图
        for(int i = 0;i<words.length-1;i++){
            int len = Math.max(words[i].length(),words[i+1].length());
            for(int j = 0;j<len;i++){
                // 这里是个坑 要防止 abc -> ab 这种情况
                if (j >= words[i].length()) break;
                if (j >= words[i+1].length()) return "";
                if(words[i].charAt(j)==words[i+1].charAt(j)){
                    continue;
                }
                Set<Character> set = graph.computeIfAbsent(words[i].charAt(j), k -> new HashSet<>());
                set.add(words[i+1].charAt(j));
                graph.put(words[i].charAt(j),set);
                break;
            }
        }

        // --------------------------------------------------这一下是拓扑排序----------------------------
        StringBuilder sb = new StringBuilder();     //结果
        Queue<Character> queue = new LinkedList<>();
        int[] rudu = new int[26];
        Arrays.fill(rudu,-1);
        int num = 0;
        for(String x:words){
            for(Character y:x.toCharArray()){
                rudu[y-'a'] = 0;
            }
        }
        for(Character x:graph.keySet()){
            for(Character y:graph.get(x)){
                rudu[x-'a']++;  //入读加一
            }
        }
        for (int i = 0; i < 26; i++) {
            if (rudu[i] == 0) {
                queue.add((char) (i + 'a'));    //入度为0的先学习
            }
            if (rudu[i] != -1) {
                num++;//有入度就++  边的个数
            }
        }
        while(!queue.isEmpty()){
            char tem = queue.poll();
            sb.append(tem);
            if (graph.containsKey(tem)) {       //如果有以这个字母未开始的边，就便利
                for (Character x : graph.get(tem)) {
                    rudu[x - 'a']--;  //删除入读==删除边
                    if (rudu[x - 'a'] == 0) {
                        queue.offer(x);
                    }
                }
            }
        }
        if(sb.length()!=num)return "";
        return sb.toString();
    }

}