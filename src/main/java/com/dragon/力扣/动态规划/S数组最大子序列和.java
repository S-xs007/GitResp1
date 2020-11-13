package com.dragon.力扣.动态规划;

public class S数组最大子序列和 {
    public int maxSubArray1(int[] nums) {
        int maxSum = nums[0];
        int pre = 0;
        for(int x:nums){
            pre = Math.max(pre + x, x);//判断之前的值加上当前的值大，还是当前的值大
            maxSum = Math.max(maxSum, pre);
        }
        return maxSum;
    }
}
