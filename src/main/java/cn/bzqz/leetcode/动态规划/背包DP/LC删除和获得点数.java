package cn.bzqz.leetcode.动态规划.背包DP;

public class LC删除和获得点数 {
    public int deleteAndEarn(int[] nums) {
        int[] bucket = new int[10001];
        for (int num : nums) {
            bucket[num] += num;
        }
        int[] dp = new int[10001];
        dp[1] = bucket[1];
        for (int i = 2; i <= 10000; i++) {
            dp[i] = Math.max(dp[i - 2] + bucket[i], dp[i - 1]);
        }
        return dp[10000];
    }

}
