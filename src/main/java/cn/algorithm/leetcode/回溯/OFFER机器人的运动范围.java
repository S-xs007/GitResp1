package cn.algorithm.leetcode.回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class OFFER机器人的运动范围 {
    //递推法
    public int movingCount(int m, int n, int k) {
       if(k==0)return 1;
       boolean[][] vis = new boolean[m][n];
       int result = 1;
       vis[0][0] = true;
       for(int i = 0;i<m;i++){
           for(int j = 0;j<n;j++){
               if(i==0&&j==0||weishu(i)+weishu(j)>k){
                   continue;
               }
               // 边界判断
               if (i  >= 1) {
                   vis[i][j] |= vis[i - 1][j];
               }
               if (j  >= 1) {
                   vis[i][j] |= vis[i][j - 1];
               }
               result += vis[i][j] ? 1 : 0; //能走就加1

           }
       }
       return result;
    }

    public int weishu(int x){
        int result = 0;
        while(x!=0){
            result+=x%10;
            x = x/10;
        }
        return result;
    }

    //宽度优先搜索
    public int movingCount1(int m, int n, int k) {
        if(k==0)return 1;
        boolean[][] visited  = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        int result = 0;
        while (queue.size()>0){
            int[] tem = queue.poll();
            int i = tem[0];
            int j = tem[1];
            if(i>=m||j>=n||weishu(i)+weishu(j)>k|| visited[i][j]){
                continue;
            }
            visited[i][j] = true;
            queue.add(new int[]{i+1,j});
            queue.add(new int[]{i,j+1});
            result += 1 ;
        }
        return result;
    }
}
