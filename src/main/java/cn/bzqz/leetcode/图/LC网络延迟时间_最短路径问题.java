package cn.bzqz.leetcode.图;

import java.util.*;
//实质上就是找到源节点K到其他节点最短距离的最大值
public class LC网络延迟时间_最短路径问题 {
    //---------------------------------迪杰斯特拉算法----------------------------------------
    //只能处理一个节点到其他所有节点的最短路径
    //无法处理父权值
    public int networkDelayTime(int[][] times, int N, int K) {
        //建立权值图
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] t : times) {
            map.computeIfAbsent(t[0], k -> new ArrayList<>()).add(new int[]{t[1], t[2]});
        }

        // 初始化dis数组和vis数组
        int[] distance = new int[N + 1];
        Arrays.fill(distance, 0x3f3f3f3f);
        boolean[] visited = new boolean[N + 1];

        // 起点的dis为0，但是别忘记0也要搞一下，因为它是不参与的，我计算结果的时候直接用了stream，所以这个0也就要初始化下了
        distance[K] = 0;
        distance[0] = 0;

        // 距离小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> distance[o1] - distance[o2]);
        // 把起点放进去
        queue.offer(K);
        //1.弹出为访问节点，标记为访问
        //2.遍历他的为访问邻居，更新源节点到他的最短路径
        //3.把邻居节点加入到队列中
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if(visited[poll]) continue;
            visited[poll] = true;
            // 遍历它的邻居们，当然可能没邻居，这里用getOrDefault处理就很方便
            List<int[]> list = map.getOrDefault(poll, new LinkedList<>());
            for (int[] arr : list) {
                int next = arr[0];
                if (visited[next]) continue;
                // 更新到这个邻居的最短距离，看看是不是当前poll出来的节点到它更近一点
                distance[next] = Math.min(distance[next], distance[poll] + arr[1]);
                queue.offer(next);
            }
        }
        // 拿到数组中的最大值比较下，返回结果
        int res = Integer.MIN_VALUE;
        for(int tem:distance){
            res = Math.max(tem,res);
        }
        return res == 0x3f3f3f3f ? -1 : res;
    }

    //-------------------------------------------------------------------------------------------
}
class Solution22222 {
    //-----------------------------------弗洛伊德算法----------------------------------------------
    //处理任意两个顶点的最短路径
    //不能处理负权值
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] g = new int[N + 1][N + 1];
        // 初始化图,注意,一开始距离是初始化为INF的，而不是像 spfa初始化成-1
        // spfa初始化成-1只是为了判断是否为邻居，这里初始化为INF是因为要取min的
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                g[i][j] = i == j ? 0 : 0x3f3f3f3f;//自己到自己是0，到别人是无穷大
            }
        }
        for (int[] t : times) {
            g[t[0]][t[1]] = t[2];//初始化权值
        }

        // 使用K节点来松弛i->j的最短路径（大白话就是利用k作为中间节点）
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    // 判断语句可以不用写，具体得看题目
                    // if (k != i && k != j && g[i][k] != INF && g[k][j] != INF) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                    // }
                }
            }
        }
        // g[a][b]表示a到b的最短距离
        // 拿结果
        int res = 0;
        for (int distance : g[K]) {
            res = Math.max(res, distance);
        }
        return res == 0x3f3f3f3f ? -1 : res;
    }
}