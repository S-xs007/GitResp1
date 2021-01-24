package cn.algorithm.leetcode.排序和搜索;

public class G归并排序 {
    public static void main(String[] args) {
        int[] x = new int[]{1,2,4,6,2,3,5};
        margeSort(x,0,x.length-1);
        for(int i:x){
            System.out.println(i);
        }
    }

    public static void margeSort(int[] nums,int l,int r){
        if(l==r)return;
        int mid = l+((r-l)>>1);
        margeSort(nums, l, mid);
        margeSort(nums, mid+1, r);
        marge(nums,l,mid,r);
    }

    public static void marge(int[] nums,int l,int mid,int r){
        int left = l;
        int right = mid+1;
        int[] tem = new int[r-l+1];
        int t = 0;
        while(left<=mid && right<=r){
            tem[t++] = nums[left]<=nums[right]?nums[left++]:nums[right++];
        }
        while (left<=mid){
            tem[t++] = nums[left++];
        }
        while (right<=r){
            tem[t++] = nums[right++];
        }

        for(int i = 0;i<t;i++){
            nums[l+i] = tem[i];
        }
    }






}
