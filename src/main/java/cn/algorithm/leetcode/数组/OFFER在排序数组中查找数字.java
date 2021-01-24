package cn.algorithm.leetcode.数组;

public class OFFER在排序数组中查找数字 {
    public int search(int[] nums, int target) {
        //求target的有边界-（target-1）的右边界
       return binarySort(nums,target)-binarySort(nums, target-1);
    }

    public int binarySort(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){             //求右边界
            int mid = left+((right-left)>>1);
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<=target){        //==也mid+1 就是因为要求右边界
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println( Runtime.getRuntime().availableProcessors());
    }
}
