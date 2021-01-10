package cn.bzqz.leetcode.图;

import java.util.*;

//节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
//
//示例1:
//
// 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
// 输出：true
//
public class LC节点间的通路_单节点连通性问题 {
    //--------------------------------------------------------------------------方法1，BFS递归
    public boolean findWhetherExistsPath(int n, int[][] edges, int start, int target) {
        //建立有向图，过滤自环边和平行边
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] e : edges) {
            if (e[0] == e[1]) continue; //（自环边）
            graph.computeIfAbsent(e[0], k -> new HashSet<>()).add(e[1]);
        }
        return dfs(graph, start, target);
    }

    /**
     * @param g == 图
     * @param cur == 当前顶点
     * @goal == 目标顶点
     * @return whether if reach to the target
     **/
    private boolean dfs(final Map<Integer, Set<Integer>> g,
                        final int cur,
                        final int goal) {
        if (cur == goal) return true; //找到了
        for (int nei : g.getOrDefault(cur, new HashSet<>())) // 遍历当前节点的每一条边 h
            if (dfs(g, nei, goal)) return true;
        return false;
    }
//---------------------------------------------------------------------------------方法2，BFS非递归
    public boolean findWhetherExistsPath3(int n, int[][] graph, int start, int target) {
        //1.建立有向图
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int[] tem:graph){
            int from = tem[0];
            int to = tem[1];
            if(from == to){
                continue;   //过滤自环边
            }
            map.computeIfAbsent(from,k -> new HashSet<>()).add(to);
        }
        return dfs1(map,start, target);
    }
    private boolean dfs1(final Map<Integer, Set<Integer>> map,
                        final int start,
                        final int target) {
        Set<Integer> used = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        used.add(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                int node = queue.poll();
                Set<Integer> set = map.get(node);
                if(set == null)continue;
                for(int to:set){
                    if(to == target)return true;//找到了
                    if(used.contains(to))continue;  //已经遍历过了
                    queue.offer(to);
                }
            }
        }
        return false;
    }

}
