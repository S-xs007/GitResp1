package cn.algorithm.leetcode.图;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC最小体力消耗路径 {
    public int minimumEffortPath(int[][] heights) { //邻接矩阵
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for(int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[0][0] = 0;

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);//小根堆
        queue.offer(new int[]{0, 0, 0});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int from = cur[0], to = cur[1];
            if(visited[from][to]) continue;
            visited[from][to] = true;
            for(int[] d : dir) {
                int nx = from + d[0], ny = to + d[1];
                if(0 <= nx && nx < m && 0 <= ny && ny < n) {
                    int effort = Math.max(dist[from][to], Math.abs(heights[from][to] - heights[nx][ny]));
                    dist[nx][ny] = Math.min(dist[nx][ny], effort);
                    queue.offer(new int[]{nx, ny, dist[nx][ny]});
                }
            }
        }
        return dist[m-1][n-1];
    }

}
