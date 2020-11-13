package com.dragon.力扣.图和并查集;

import java.util.*;

public class Le_safeNode {
    //graph = [[1,2],[2,3],[5],[0],[5],[],[]]
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int N = graph.length;
            boolean[] safe = new boolean[N];

            List<Set<Integer>> zgraph = new ArrayList();
            List<Set<Integer>> rgraph = new ArrayList();    //反向图
            for (int i = 0; i < N; ++i) {
                zgraph.add(new HashSet());
                rgraph.add(new HashSet());
            }

            Queue<Integer> queue = new LinkedList();

            for (int i = 0; i < N; ++i) {
                if (graph[i].length == 0)       //只有入度就近队列
                    queue.offer(i);
                for (int j: graph[i]) {
                    zgraph.get(i).add(j);
                    rgraph.get(j).add(i);
                }
            }

            //核心算法
            while (!queue.isEmpty()) {
                int j = queue.poll();       //弹出一个只有入读的点，该点是安全的
                safe[j] = true;
                for (int i: rgraph.get(j)) {
                    zgraph.get(i).remove(j);     //删除相关的边
                    if (zgraph.get(i).isEmpty()) //删除之后如果这条边没有入读了
                        queue.offer(i); //这个点也入对
                }
            }

            //
            List<Integer> ans = new ArrayList();
            for (int i = 0; i < N; ++i) if (safe[i])
                ans.add(i);

            return ans;
        }


        public List<Integer> eventualSafeNodes1(int[][] graph) {
            int N = graph.length;
            int[] color = new int[N];
            List<Integer> ans = new ArrayList();

            for (int i = 0; i < N; ++i)
                if (dfs(i, color, graph))
                    ans.add(i);
            return ans;
        }

        // colors: WHITE 0, GRAY 1, BLACK 2;
        public boolean dfs(int node, int[] color, int[][] graph) {
            if (color[node] > 0)
                return color[node] == 2;

            color[node] = 1;
            for (int nei: graph[node]) {
                if (color[node] == 2)
                    continue;
                if (color[nei] == 1 || !dfs(nei, color, graph))
                    return false;
            }

            color[node] = 2;
            return true;
        }
    }






