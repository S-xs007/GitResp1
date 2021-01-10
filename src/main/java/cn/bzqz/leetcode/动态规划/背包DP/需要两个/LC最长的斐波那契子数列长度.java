package cn.bzqz.leetcode.动态规划.背包DP.需要两个;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC最长的斐波那契子数列长度 {
    class Solution {
        public int lenLongestFibSubseq(int[] A) {
            int n=A.length;
            Map<Integer,Integer> map=new HashMap<>();//定义HashMap用来记录A中是否存在A[j]-A[i]的值map存的就是<值，索引>
            for(int i=0;i<n;i++){
                map.put(A[i],i);
            }
            int[][] dp=new int[n][n-1];//dp表示以索引j，i结尾的最大斐波拉契数列长度
            for(int[] d:dp){        //将dp的每个值初始化为2
                Arrays.fill(d,2);
            }
            int max=0;
            for(int i=2;i<n;i++){
                for(int j=i-1;j>0;j--){
                    if(2*A[j]>A[i]&&map.containsKey(A[i]-A[j])){ //第一个判断用来保证j大于A[i]-A[j]的索引
                        dp[i][j]=dp[j][map.get(A[i]-A[j])]+1;
                        max=Math.max(max,dp[i][j]);  //在dp的过程中更新最大值
                    }
                }
            }
            return max==2?0:max;
        }
    }
}
