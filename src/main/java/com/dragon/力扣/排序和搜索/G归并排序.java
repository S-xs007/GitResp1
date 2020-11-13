package com.dragon.力扣.排序和搜索;

public class G归并排序 {
    public static void margeSort(int[] nums,int l,int r){
        if(l==r)return;
        int mid = l+((r-l)>>1);
        margeSort(nums,l,mid);
        margeSort(nums,mid+1,r);
        marge(nums,l,mid,r);
    }

    public static void marge(int[] nums,int left,int mid,int right){
        int l = left;
        int r = mid+1;

        int[] tem = new int[right-left+1];
        int index = 0;
        while(l<=mid&&r<=right){
            tem[index++] = (nums[l]<nums[r])?nums[l++] : nums[r++];
        }
        while(l<=mid){
            tem[index++] = nums[l++];
        }
        while (r<=right){
            tem[index++] = nums[r++];
        }
        for(int i = 0;i<tem.length;i++){
            nums[left+i] = tem[i];
        }
    }


    public static void main(String[] args) {
        int[] x = new int[]{1,2,4,6,2,3,5};
        G归并排序.margeSort(x,0,x.length-1);
        for(int i:x){
            System.out.println(i);
        }
    }









}
