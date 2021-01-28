package cn.algorithm.leetcode.动态规划.零一背包;

public class LC分割等和子集 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if ((sum & 1) != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        //1.第n个数字  背包容量是数组和的一半
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                //当前的先不选
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {//如果可以选（容量>当前重量）
                    dp[i][j] = dp[i][j] | dp[i - 1][j - num];
                }
            }
        }
        return dp[n - 1][target];
    }
}
