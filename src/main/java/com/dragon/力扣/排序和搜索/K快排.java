package com.dragon.力扣.排序和搜索;

/**
 * 快速排序演示
 * 核心思想就是：
 * 先从右边开始扫描，找到第一个小然后交换
 * 再从左边扫描，找到第一个大的进行交换
 * 知道左边的指针遇到右边指针就退出
 *
 * 然后对左边和右边进行上述操作
 */
public class K快排 {
    public static void quickSort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int l = left;
        int r = right;
        int key = nums[l];
        while(l<r){
            while(l<r && nums[r]>=key){
                r--;
            }
            swap(nums, l, r);
            while(l<r && nums[l]<=key){
                l++;
            }
            swap(nums, l, r);
        }
        quickSort(nums,0,l-1);
        quickSort(nums,r+1,right);

    }

    public static void swap(int[] nums,int l,int r){
        int tem = nums[l];
        nums[l] = nums[r];
        nums[r] = tem;
    }

    public static void main(String[] args) {
        int[] arr = {5,3,6,3,5,3,5,32,1,7,2};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }












}
