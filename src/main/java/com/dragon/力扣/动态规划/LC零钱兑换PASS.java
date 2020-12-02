package com.dragon.力扣.动态规划;

import java.util.*;

public class LC零钱兑换PASS {
    /**
     * 零钱兑换
     * @param coins     不同面额的硬币
     * @param amount    总金额
     * @return          所需的硬币的最小个数
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for(int i = 1;i<=amount;i++){           //从1块钱开始
            for(int j = 0;j<coins.length;j++){  //遍历硬币序列
                if(i>=coins[j]) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1,dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
