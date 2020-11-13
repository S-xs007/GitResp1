package com.dragon.力扣.数组和字符串;

import java.util.HashMap;
import java.util.HashSet;

public class L1两数之和 {
    /**
     * 时间复杂度O(n2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for(int i =0;i<len;i++){
                int x = target-nums[i];
                for(int j = i+1;j<len;j++){
                    if(nums[j]==x){
                        return new int[]{i,j};
                    }
                }
            }
        return new int[]{-1,-1};
    }

    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i< nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i );
        }
        return new int[]{-1,-1};
    }

    }
