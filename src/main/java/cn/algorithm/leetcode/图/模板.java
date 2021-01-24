package cn.algorithm.leetcode.图;

import java.util.*;

public class 模板 {
    //DFS
    Set<Integer> used = new HashSet<>();    //保存访问过的顶点
    int count = 0;//走了多少步
    public boolean findWhetherExistsPath(int n, int[][] edges, int start, int target) {
        //建立有向图，过滤自环边和平行边
        Map<Integer, Set<Integer>> graph = new HashMap<>(); //有向图的模板
        for (int[] e : edges) {
            if (e[0] == e[1]) continue; //（自环边）
            graph.computeIfAbsent(e[0], k -> new HashSet<>()).add(e[1]);
        }
        return dfs(graph, start, target);   //dfs从start寻找target
    }

    private boolean dfs(final Map<Integer, Set<Integer>> g,
                        final int cur,
                        final int goal) {
        if (cur == goal) return true; //找到了
        used.add(cur);
        for (int nei : g.getOrDefault(cur, new HashSet<>())){// 遍历当前节点的每一条边 h
            if(!used.contains(nei)){
                if (dfs(g, nei, goal)) return true;
            }
        }
        return false;
    }
}
class A{
    //BFS
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
        Queue<Integer> queue = new LinkedList<>();  //使用队列
        queue.offer(start);
        used.add(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){  //遍历第一层
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

    //最小生成树Kruskal  贪心+并查集

    /**
     * Kruskal算法 = 贪心 + 并查集
     *
     * 流程：将所有边按cost从小到大排序，然后使用并查集依次尝试合并每个边：
     *
     * 如果合并成功，则加入这条边。
     * 如果合并失败（边的两个节点已经是合并过的），说明产生了环，则丢弃这条边。
     * 通过并查集合并后，每个连通分量节点都会有相同的root，因此检查所有节点的root：
     *
     * 如果检查到只有一个root，说明这个图只有一个连通分量，是连通图，返回cost。
     * 如果检查到超过一个root，说明这个图有多个连通分量，不是一个连通图，返回-1。
     *
     * @param N 节点个数
     * @param connections 二维数组  1  2  5   （1-2 全职 5）
     * @return
     */
    public int minimumCost(int N, int[][] connections) {
       //对边的权值进行排序(小 --- 大)
        Arrays.sort(connections, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        int[] parent = new int[N+1];    //保存父节点
        for (int i = 1; i <= N; ++i) {
            parent[i] = i;//初始化，自己就是自己的父节点
        }

        int cost = 0;
        for (int[] edge : connections) {//遍历每一条边
            if (union(edge[0], edge[1], parent)) {
                cost += edge[2];
            }
        }

        int p = -1;
        for (int i = 1; i <= N; ++i) {
            int root = findRoot(i, parent); //并查集之后，所有的节点都有一个父节点
            if (p == -1) {
                p = root;
            } else if (p != root) {
                return -1;
            }
        }
        return cost;
    }

    public int findRoot(int x, int[] parent) {//寻找根节点
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean union(int a, int b, int[] parent) {
        a = findRoot(a, parent);
        b = findRoot(b, parent);
        if (a == b) return false;   //根节点相同就不加入
        parent[a] = b;
        return true;
    }
    //Prim算法
    //1.转化为邻接表      Map<Integer, List<int[]>> graph
    //2.建立按照权值由小到大的小根堆  PriorityQueue
    //3.
    public int minimumCost1(int N, int[][] connections) {

        // graph.get(i).get(x):
        //     int[0]: to顶点
        //     int[1]: 距离 from [i] to [x]
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : connections) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.computeIfAbsent(u,k->new LinkedList<>()).add(new int[]{v,w});
            graph.computeIfAbsent(v,k->new LinkedList<>()).add(new int[]{u,w});
        }

        //距离的小根堆
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // 保存已经使用的节点
        boolean[] added = new boolean[N+1];

        heap.offer(new int[]{1, 0});

        int cost = 0;
        for (int k = 0; k < N; ++k) {
            int[] min = findMin(heap, added);
            if (min == null) {
                return -1;
            }
            int node = min[0];
            int dist = min[1];
            cost += dist;
            added[node] = true;
            List<int[]> list = graph.get(node);
            if (list != null) {
                for (int[] e : list) {  //to 节点的所有相邻节点加入到堆中
                    heap.offer(e);
                }
            }
        }
        return cost;
    }

    public int[] findMin(PriorityQueue<int[]> heap, boolean[] added) {
        while (heap.size() > 0) {
            int[] n = heap.poll();//弹出权值最小的（前提是没有使用过）
            int node = n[0];
            if (!added[node]) {
                return n;
            }
        }
        return null;
    }

    //迪杰斯特拉
    //不能设置为Integer.MAX_VALUE，否则两个Integer.MAX_VALUE相加会溢出导致出现负权
    public static int MaxValue = 100000;
    //给定邻接矩阵
    public static void dijstra(int[][] matrix, int source) {
        //最短路径长度
        int[] shortest = new int[matrix.length];
        //判断该点的最短路径是否求出
        int[] visited = new int[matrix.length];
        //存储输出路径
        String[] path = new String[matrix.length];

        //初始化输出路径
        for (int i = 0; i < matrix.length; i++) {
            path[i] = new String(source + "->" + i);
        }

        //初始化源节点
        shortest[source] = 0;
        visited[source] = 1;

        for (int i = 1; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < matrix.length; j++) {
                //已经求出最短路径的节点不需要再加入计算并判断加入节点后是否存在更短路径
                if (visited[j] == 0 && matrix[source][j] < min) {
                    min = matrix[source][j];
                    index = j;
                }
            }

            //更新最短路径
            shortest[index] = min;
            visited[index] = 1;

            //更新从index跳到其它节点的较短路径
            for (int m = 0; m < matrix.length; m++) {
                if (visited[m] == 0 && matrix[source][index] + matrix[index][m] < matrix[source][m]) {
                    matrix[source][m] = matrix[source][index] + matrix[index][m];
                    path[m] = path[index] + "->" + m;
                }
            }

        }
    }


}
