package cn.algorithm.leetcode.动态规划;

public class OFFER连续子数组的最大和PASS {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int pre = nums[0];
        int max = pre;
        for(int i = 1;i< nums.length;i++){
            pre = Math.max(pre+nums[i],nums[i]);    //重点：必须有nums[i] 因为时连续子数组的最大和
            max = Math.max(max,pre);
        }
        return max;
    }
}
