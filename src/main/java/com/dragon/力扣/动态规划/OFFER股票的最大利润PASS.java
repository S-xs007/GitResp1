package com.dragon.力扣.动态规划;

public class OFFER股票的最大利润PASS {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)return 0;
        int min = Integer.MAX_VALUE;
        int maxPro = Integer.MIN_VALUE;
        for(int i:prices){
            if(i<min)min = i;
            maxPro = Math.max(maxPro,i-min);
        }
        return maxPro;
    }
}
