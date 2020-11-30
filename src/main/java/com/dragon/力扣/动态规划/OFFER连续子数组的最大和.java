package com.dragon.力扣.动态规划;

public class OFFER连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
            int pre = nums[0];
            int max = pre;
            for(int i = 1;i<nums.length;i++){
                pre = Math.max(pre+nums[i],nums[i]);
                max = Math.max(pre,max);
            }
            return max;
    }
}
