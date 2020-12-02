package com.dragon.力扣.图和并查集;

public class OFFER礼物的最大价值PASS {
    public int maxValue(int[][] grid) {

    return f(grid,0,0);
    }

    public int f(int[][] grid,int i,int j){
        int row = grid.length;
        int cow = grid[0].length;
        if(i<0||i>=row||j<0||j>=cow){
            return 0;
        }
        return Math.max(f(grid,i+1,j),f(grid,i,j+1))+grid[i][j];
    }


    public int maxValue1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int j = 1; j < n; j++) // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        for(int i = 1; i < m; i++) // 初始化第一列
            grid[i][0] += grid[i - 1][0];
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
        return grid[m - 1][n - 1];
    }

}
