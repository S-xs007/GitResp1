package cn.algorithm.leetcode.动态规划.三种典型的问题.第一种组合问题;

public class LC组合总数 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;

            for(int i = 1;i<=target;i++){
                for(int num:nums){
                if(i<num){
                    continue;
                }
                dp[i] += dp[i-num];
            }
        }
            return dp[target];
    }
}
