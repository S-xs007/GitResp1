package cn.bzqz.leetcode.图;

import java.util.*;

public class LC判断二分图 {
    public boolean isBipartite1(int[][] graph) {
        int[] used = new int[graph.length];//定义 used 数组，初始值为 0 表示未被访问，赋值为 1 或者 -1 表示两种不同的颜色。
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<graph.length;i++){ // 因为图中可能含有多个连通域，所以我们需要判断是否存在顶点未被访问，若存在则从它开始再进行一轮 bfs 染色。
            if(used[i]!=0) continue;
            queue.offer(i);
            used[i] = 1;//着色
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int j = 0;j<size;j++){
                    int node = queue.poll();
                    for(int tem:graph[node]){
                        if(used[tem] == used[node])return false;//一条边上的两个节点颜色不可以相同
                        if(used[tem] == 0){
                            used[tem] = -used[node];
                            queue.offer(tem);
                        }
                    }
                }
            }
        }
        return true;
    }
}
