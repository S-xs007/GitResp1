package cn.bzqz.leetcode.动态规划.完全背包;

/**
 * 什么是完全背包问题？
 * 背包内的物品无限次选取
 */
public class LC518_零钱兑换Ⅱ {
    //和爬楼梯有什么区别？
    //爬楼梯只需要关注 n-1 和 n-2 如果每次可以上1，2，5层台阶呢？  需要关注 n-1  n-2  n-5
    //实际上这道题也是一样的，我们就好比coins数组中的数 就是我们每次可以上的台阶
    //dp[i] = dp[i-coins[0]] + dp[i-coins[1]]...
    public int change(int amount, int[] coins) {
        //给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin:coins){
            for(int i = coin;i<=amount;i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
