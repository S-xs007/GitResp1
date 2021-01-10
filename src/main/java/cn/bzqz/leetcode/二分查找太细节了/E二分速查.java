package cn.bzqz.leetcode.二分查找太细节了;

public class E二分速查 {
    //-----------------------------------------基本二分
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while(left <= right) { // 注意
            int mid = (right + left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }
    //---------------------------------左边界

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
        return left;
    }

    //第一个错误的版本
    /*public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while(l<r){
            int mid = l+((r-l)>>1);
            if(isBadVersion(mid)==false){
                l = mid+1;
            }else if(isBadVersion(mid)==true){
                r = mid;
            }
        }
        return l;
    }*/
    //寻找波峰(题目说了不会出现相邻相等的情况)
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = l+((r-l)>>1);
            if(nums[mid]>nums[mid+1]){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    //寻找旋转排序数组中的最小值
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = l+((r-l)>>1);
            if(nums[mid]>=nums[r]){
                l = mid+1;
            }else if(nums[mid]<nums[r]){
                r = mid;
            }
        }
        return nums[l];
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
        return left - 1; // 注意
    }
    //--------------------------------------------
    //标准二分
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = (l+r)>>1;
            if(nums[mid] == target)return mid;
            else if(nums[mid]<target)l = mid+1;
            else r = mid-1;
        }
        return -1;
    }
    //得到平方根
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    //猜数字
    /*public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int l = 0;
            int r = n;
            while(l<=r){
                int mid = l+((r-l)>>1);
                if(guess(mid)==-1){
                    r = mid-1;
                }else if(guess(mid)==1){
                    l = mid+1;
                }else if(guess(mid)==0){
                    return mid;
                }
            }
            return -1;
        }
    }*/
    //搜索旋转排序数组
    public int search2(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) { //mid>=左侧 说明左侧一定是有序的
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {        //如果mid《左侧 说明右侧一定是有序的
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,5,7,9,10};
        E二分速查 e二分速查 = new E二分速查();
        System.out.println(e二分速查.left_bound(nums,6));
    }
}
