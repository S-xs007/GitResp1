package com.dragon.力扣.排序和搜索;

public class 二分查找 {
    public static boolean exist(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int l = 0;
        int r = nums.length-1;
        while (l<r){
            int mid = l+((r-l)>>1);
            if(nums[mid]==target)return true;
            if(nums[mid]<target){
                l = mid+1;
            }else if(nums[mid]>target){
                r = mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,3,4,5,6,9,10};
        System.out.println(exist1(nums,6));
    }
    public static int exist1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length-1;
        while (l<r){
            int mid = l+((r-l)>>1);
            if(nums[mid]==target)return mid;
            if(nums[mid]<target){
                l = mid+1;
            }else if(nums[mid]>target){
                r = mid-1;
            }
        }
        return -1;
    }
}
