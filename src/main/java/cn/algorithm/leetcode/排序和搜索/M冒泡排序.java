package cn.algorithm.leetcode.排序和搜索;
/**
 * @Author: zxS
 * @Date: 11:36 2020/11/27
 * @Description：每次把最大的放到最后面
 */
public class M冒泡排序 {
    public static void swap(int[] nums,int i,int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
    public static void paoSort(int[] nums){
        for(int index = 0;index<nums.length;index++)
            for(int i = 0;i+1<nums.length-index;i++){
                if(nums[i]>nums[i+1]){
                    swap(nums,i,i+1);
                }
            }
        }
    }


