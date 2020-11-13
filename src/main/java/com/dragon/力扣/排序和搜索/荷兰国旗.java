package com.dragon.力扣.排序和搜索;

/**
 * 大于target在右边
 * =在中间
 * <在左边
 */
public class 荷兰国旗 {
    public static void sort(int[] nums,int target){
        int len = nums.length;
        int small = -1;
        int big = len;
        int i =0;
        while(i<len&&i<big){
            if(nums[i]>target){
                swap(nums,i,big-1);
                big--;
            }else if(nums[i]==target){
                i++;
            }else{
                swap(nums,small+1,i);
                small++;
                i++;
            }
        }
    }

    public static void swap(int[] nums,int i,int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
       /* nums[i] = nums[i]^nums[j];
        nums[j] = nums[i]^nums[j];
        nums[i] = nums[i]^nums[j];*/
    }

    public static void main(String[] args) {
        int[] nums = {3,5,4,0,4,6,7,2};
        荷兰国旗.sort(nums,4);
        for(int i:nums){
            System.out.println(i);
        }
    }
}
