package com.dragon.力扣.动态规划;

public class M买股票的最佳时机 {

    //买卖股票的最佳时机
    public int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE;    //当前股票的最小值
        int maxPro = 0;//当前最大收益

        for(int i = 0;i<prices.length;i++){
            if(prices[i]<min)min = prices[i];
            maxPro = Math.max(maxPro,prices[i]-min);
        }
        return maxPro;
    }





































}
