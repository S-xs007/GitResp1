package com.dragon.力扣.排序和搜索;
/**
 * @Author: zxS
 * @Date: 11:28 2020/11/27
 * @Description：每次选出来最小值放到最前面
 */
public class X选择排序 {

    public static void selectSort(int[] nums){
            int len = nums.length;

            int left = 0;
            int minWeizhi = 0;
            while(left<len){
                int min = Integer.MAX_VALUE;
                for(int i = left;i<len;i++){        //遍历一次找到最小值和他的位置
                    if(nums[i]<min){
                        min = nums[i];
                        minWeizhi = i;
                    }
                }
                swap(nums,left,minWeizhi);  //交换
                left++;

            }
    }

    public static void swap(int[] nums,int i,int j){
            int tem = nums[i];
            nums[i] = nums[j];
            nums[j] = tem;
    }
}
