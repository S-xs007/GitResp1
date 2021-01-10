package cn.bzqz.leetcode.动态规划.三种典型的问题.第一种组合问题;

public class LC零钱兑换Ⅱ {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin:coins){
        for(int i = 1;i<=amount;i++){
                if(i<coin)continue;
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
