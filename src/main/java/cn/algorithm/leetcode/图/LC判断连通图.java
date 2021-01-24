package cn.algorithm.leetcode.图;

import java.util.*;

//输入：n = 5, e = [[0,1],[2,3],[1,4]]
//输出：False
public class LC判断连通图 {
    Set<Integer> used = new HashSet<>();
    public boolean isConnectGraph(int n, int[][] e) {
        //建立无向图
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] edag:e){
            int from = edag[0];
            int to = edag[1];
            if(from == to)continue;
            map.computeIfAbsent(from,k->new HashSet<>()).add(to);
            map.computeIfAbsent(to,k->new HashSet<>()).add(from);
        }
        //开始广度优先
        bfs(map,0);
        if(used.size() == n)return true;
        return false;

    }

    private void bfs(Map<Integer, Set<Integer>> map,int cur) {
        used.add(cur);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neibor:map.getOrDefault(node,new HashSet<>())){
                if(used.contains(neibor))continue;
                used.add(neibor);
                queue.offer(neibor);
            }
        }
    }

    public static void main(String[] args) {
        LC判断连通图 lc判断连通图 = new LC判断连通图();
        System.out.println(lc判断连通图.isConnectGraph(5,new int[][]{{0,1},{2,3},{1,4}}));
    }
}
