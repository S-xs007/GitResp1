package cn.algorithm.leetcode.动态规划.数组DP_OK;

public class LC63_最小路径和 {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
      int m = grid.length;
      int n = grid[0].length;
      int[][] pathSum = new int[m][n];
      pathSum[0][0] = grid[0][0];
      for(int i =1;i<m;i++){
          pathSum[i][0] =grid[i][0]+pathSum[i-1][0];
      }
      for(int i =1;i<n;i++){
          pathSum[0][i] =grid[0][i]+pathSum[0][i-1];
      }
      for(int i =1;i<m;i++){
          for(int j =1;j<n;j++){
              pathSum[i][j] = grid[i][j] + Math.min(pathSum[i-1][j],pathSum[i][j-1]);
          }
      }
      return pathSum[m-1][n-1];

    }
}
