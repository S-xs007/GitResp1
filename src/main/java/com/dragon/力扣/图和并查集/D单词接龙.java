package com.dragon.力扣.图和并查集;

import java.util.*;

public class D单词接龙 {
        Map<String, Integer> wordId = new HashMap<String, Integer>();       //每个单词  对应的id
        List<List<Integer>> edge = new ArrayList<List<Integer>>();  //边
        int nodeNum = 0;

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            for (String word : wordList) {
                addEdge(word);
            }
            addEdge(beginWord);

            //如果wordList里面没有endWorld 直接返回0
            if (!wordId.containsKey(endWord)) {
                return 0;
            }

            int[] dis = new int[nodeNum];
            Arrays.fill(dis, Integer.MAX_VALUE);
            int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
            dis[beginId] = 0;

            //开始广度优先搜索
            Queue<Integer> que = new LinkedList<Integer>();
            que.offer(beginId);
            while (!que.isEmpty()) {
                int x = que.poll();
                if (x == endId) {
                    return dis[endId] / 2 + 1;      //去掉一般的虚拟节点和一个起点
                }
                for (int it : edge.get(x)) {
                    if (dis[it] == Integer.MAX_VALUE) {
                        dis[it] = dis[x] + 1;
                        que.offer(it);
                    }
                }
            }
            return 0;
        }
    //添加边
    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }


}

class Solution{
    HashMap<String,Integer> wordId = new HashMap<>();      //存放单词的id
    List<List<Integer>> edge = new ArrayList<>(); //变
    int num = 0;
    //单词接龙
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for(String x:wordList){
            addEdge(x);
        }
        addEdge(beginWord);
        if(!wordId.containsKey(endWord))return 0;
        //开始广度优先搜索
        int[] dis = new int[num];  //记录每个节点
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(beginId);
        while(!queue.isEmpty()){
            int tem = queue.poll();
            if(tem==endId)return dis[endId]/2+1;
            for(int s:edge.get(tem)){
                if(dis[s]==Integer.MAX_VALUE){  //没走过
                    dis[s] = dis[tem] + 1;
                    queue.offer(s);
                }

            }
        }
        return 0;
    }

    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] words = word.toCharArray();
        int len = word.length();
        for(int i = 0;i<len;i++){
            char tem = words[i];
            words[i] = '*';
            String str = new String(words);
            addWord(str);
            int id2 = wordId.get(str);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            words[i] = tem;
        }
    }


        public void addWord(String word) {
        if(!wordId.containsKey(word)){
            wordId.put(word,num++);
            edge.add(new ArrayList<Integer>());
        }
    }
}























































