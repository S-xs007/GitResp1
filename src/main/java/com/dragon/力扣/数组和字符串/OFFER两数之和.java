package com.dragon.力扣.数组和字符串;

import java.util.HashMap;
import java.util.HashSet;

public class OFFER两数之和 {
    //双指针
    public int[] twoSum2(int[] nums, int target) {
        int[] res = {-1,-1};
            int left = 0;
            int right = nums.length-1;
            while(left<right){
                if(nums[left]+nums[right]<target){
                    left++;
                }else if(nums[left]+nums[right]>target){
                    right--;
                }else{
                    return new int[]{nums[left],nums[right]};
                }
            }
        return res;

    }
    }



