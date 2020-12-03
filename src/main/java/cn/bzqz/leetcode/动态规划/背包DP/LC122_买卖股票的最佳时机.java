package cn.bzqz.leetcode.动态规划.背包DP;

import java.util.Deque;
import java.util.LinkedList;

public class LC122_买卖股票的最佳时机 {
    //2.可以多次交易
    public int maxProfit(int[] prices) {
        if(prices.length==0||prices==null)return 0;
        int res = 0;
        int min = prices[0];
        int max = prices[0];
        for(int i = 1;i<prices.length;i++){
            if(prices[i]<prices[i-1]){
                //出现降序
                res+=(max-min);
                max = prices[i];
                min = prices[i];
            }else if(prices[i]>prices[i-1]){
                //升序
                max = prices[i];
            }
            if(i==prices.length-1&&i>0){    //防止结束的时候还是升序
                if(prices[i]>=prices[i-1]){
                    res += (max-min);
                    return res;
                }
            }
        }
        return res;
    }

    //另一种贪心思想
    public int maxProfit1(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    //3.最多两笔交易
    public int maxProfit3(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 第 1 维的 0 没有意义，1 表示买入进行了 1 次，2 表示买入进行了 2 次
        // 为了使得第 1 维的数值 1 和 2 有意义，这里将第 1 维的长度设置为 3
        int[][] dp = new int[3][2]; //第二维  0表示没有持股   1表示持股

        // 理解如下初始化
        // 第 2 维规定了必须持股，因此是 -prices[0]
        dp[1][1] = -prices[0];
        dp[2][1] = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            //交易一次
            dp[1][1] = Math.max(dp[1][1], -prices[i]);      //买了一次但是没卖，看看那个便宜买哪个
            dp[1][0] = Math.max(dp[1][0], dp[1][1] + prices[i]);//买了一次卖了
            //交易两次
            dp[2][1] = Math.max(dp[2][1], dp[1][0] - prices[i]);
            dp[2][0] = Math.max(dp[2][0], dp[2][1] + prices[i]);
        }
        return Math.max(dp[1][0], dp[2][0]);//买入一次和买入两次的最大值


    }
}
