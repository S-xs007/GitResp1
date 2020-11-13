package com.dragon.力扣.图和并查集;

public class D岛屿数量 {
    public int numIslands(char[][] grid) {
        int c = grid.length;
        int k = grid[0].length;
        int dao = 0;
        for(int i = 0;i<c;i++){
            for(int j = 0;j<k;j++){
                if(grid[i][j]=='1'){
                    dao++;
                    dfs(grid,i,j);
                }

            }
        }
        return dao;
    }

    public void dfs(char[][] grid,int i,int j){
        int c = grid.length;
        int k = grid[0].length;
        if(i<0||i>=c||j>=k||j<0||grid[i][j]=='0'){       //判断边界
            return;
        }
            grid[i][j]='0';
            dfs(grid,i-1,j);
            dfs(grid,i,j+1);
            dfs(grid,i+1,j);
            dfs(grid,i,j-1);

    }
}
