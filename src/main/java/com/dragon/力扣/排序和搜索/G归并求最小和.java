package com.dragon.力扣.排序和搜索;

/**
 * 求最小和
 */
public class G归并求最小和 {
    public static int smallSum(int[] nums){
        if(nums==null||nums.length<2){
            return 0;
        }
        return mergeSort(nums,0,nums.length-1);
    }
    //递归
    public static int mergeSort(int[] nums,int l,int r){
        if(l==r){
            return 0;
        }
        int mid = l+((r-l)>>1);
       return mergeSort(nums,l,mid)+
        mergeSort(nums,mid+1,r)+
        merge(nums,l,mid,r);
    }

    private static int merge(int[] nums, int l, int mid, int r) {
        int left = l;
        int right = mid+1;
        int[] tem = new int[r-l+1];
        int t = 0;
        int sum = 0;
        while(left<=mid&&right<=r){
            sum+=nums[left]<nums[right]?(r-right+1)*nums[left]:0;
            tem[t++] = (nums[left]<nums[right])?nums[left++]:nums[right++];

        }

        while(left<=mid){
            tem[t++] = nums[left++];
        }
        while(right<=r){
            tem[t++] = nums[right++];
        }
        for(int i = 0;i<tem.length;i++){
            nums[l+i] = tem[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] x= {7,5,4,8,9,10};
        System.out.println(G归并求最小和.mergeSort(x,0,x.length-1));
        for(int i:x){
            System.out.println(i);
        }
    }
}
