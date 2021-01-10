package cn.bzqz.leetcode.动态规划.数组DP_OK;

import java.util.List;

public class LC120_三角形的最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] f = new int[m][m];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[m - 1][0]; //最后一行第一个
        for (int i = 1; i < m; ++i) {
            minTotal = Math.min(minTotal, f[m - 1][i]);
        }
        return minTotal;
    }

    //youhua1
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }

}
