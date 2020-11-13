package com.dragon.力扣.动态规划;

public class D打家劫舍 {
    public int rob(int[] nums) {
        if(nums.length==0||nums==null)return 0;
        if(nums.length==1)return nums[0];
        int len = nums.length;
        int[] price = new int[len];
        price[0] = nums[0];
        price[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<len;i++){
            price[i] = Math.max(price[i-1],nums[i]+price[i-2]);
        }
        return price[len-1];
    }
}
