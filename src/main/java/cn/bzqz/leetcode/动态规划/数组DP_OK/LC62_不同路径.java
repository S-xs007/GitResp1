package cn.bzqz.leetcode.动态规划.数组DP_OK;

public class LC62_不同路径 {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m+1][n+1];
        path[1][1] = 1;
        for(int i = 2;i<=m;i++){
            path[i][1] = 1;
        }
        for(int i = 2;i<=n;i++){
            path[1][i] = 1;
        }
        for(int i = 2;i<=m;i++){
            for(int j = 2;j<=n;j++){
                path[i][j] =  path[i-1][j] + path[i][j-1];
            }
        }
        return path[m][n];
    }

    //不同路径二 有障碍物
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] path = new int[m+1][n+1];
        if(obstacleGrid[0][0]==1)return 0;
        else path[1][1] = 1;
        for(int i = 2;i<=m;i++){
            if(obstacleGrid[i-1][0]==1){
                break;
            }
            path[i][1] = 1;
        }
        for(int i = 2;i<=n;i++){
            if(obstacleGrid[0][i-1]==1){
                break;
            }
            path[1][i] = 1;
        }
        for(int i = 2;i<=m;i++){
            for(int j = 2;j<=n;j++){
                if(obstacleGrid[i-1][j-1]==1){
                    path[i][j] = 0;
                    continue;
                }
                path[i][j] =  path[i-1][j] + path[i][j-1];
            }
        }
        return path[m][n];
    }
}
