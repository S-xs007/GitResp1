package cn.bzqz.leetcode.二分查找太细节了;

public class LC查找左右边界 {
    //第一个位置和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int left = left_bound(nums,target);
        if(left==-1)return new int[]{-1,-1};
        return new int[]{left,right_bound(nums,target)};
    }
    //-----------------------------------------------右边界
    int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if(left-1>=nums.length )return -1;  //left-1可能会越界
        return nums[left-1]==target?left - 1 : -1; // 注意
    }
    //左边界
    int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意
        while (left < right) { // 注意
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid; // 注意
            }
        }
        if(left>=nums.length )return -1;    //left可能会越界
        return nums[left]==target?left : -1;
    }

}
