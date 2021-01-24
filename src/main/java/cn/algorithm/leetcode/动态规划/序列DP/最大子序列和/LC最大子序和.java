package cn.algorithm.leetcode.动态规划.序列DP.最大子序列和;

public class LC最大子序和 {
    public int maxSubArray(int[] nums) {
        if(nums.length==0)return 0;
        int pre = nums[0];
        int maxSum = pre;
        for(int i = 1;i<nums.length;i++){
            pre = Math.max(pre+nums[i],nums[i]);
            maxSum = Math.max(maxSum,pre);
        }
        return maxSum;
    }
}
