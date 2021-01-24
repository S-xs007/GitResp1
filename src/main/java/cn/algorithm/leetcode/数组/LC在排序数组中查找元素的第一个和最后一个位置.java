package cn.algorithm.leetcode.数组;

public class LC在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }

        int firstPosition = findFirstPosition(nums, target,true);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }

        int lastPosition = findFirstPosition(nums, target,false);
        return new int[]{firstPosition, lastPosition};
    }

    private int findFirstPosition(int[] nums, int target,boolean flag) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = 0;
            if(flag)mid = left + (right - left) / 2;    //左边界
            else mid = left + (right - left + 1) / 2;   //有边界
            // 小于一定不是解
            if (nums[mid] < target) {
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] > target ) {
                // nums[mid] > target，下一轮搜索区间是 [left, mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索区间是 [left, mid]             //相等的时候不返回，然后因为要找到左边界，就去左面找
                if(flag)right = mid;
                else left = mid;
            }
        }
        if (nums[left] == target || !flag) {
            return left;
        }
        return -1;
    }
}
class Solution22 {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {findLeft(nums, target), findRight(nums, target)};
    }

    private int findLeft(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, index = -1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
            if (nums[mid] == target) index = mid;
        }
        return index;
    }

    private int findRight(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, index = -1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] <= target) lo = mid + 1;
            else hi = mid - 1;
            if (nums[mid] == target) index = mid;
        }
        return index;
    }
}
