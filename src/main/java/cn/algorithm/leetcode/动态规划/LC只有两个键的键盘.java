package cn.algorithm.leetcode.动态规划;

public class LC只有两个键的键盘 {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {  //从二开始是因为原来就有一个“A"
            dp[i] = i;
            for (int j = 2; j <= Math.sqrt(n); j++) {   //从2开始寻找因子
                if (i % j == 0) {   //找到了
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }


}
