package cn.algorithm.leetcode.动态规划.零一背包;

public class LC一和零 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for(String str : strs) {
            int[] res = getZeroAndOneNum(str);
            int zero = res[0];
            int one = res[1];
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-zero][j-one]+1);
                }
            }
        }
        return dp[m][n];
    }

    //计算字符串中零和1的数量
    public int[] getZeroAndOneNum(String str){
        int[] res = new int[2];
        for(char tem : str.toCharArray()){
            res[tem-'0']++;
        }
        return res;
    }
}
