package cn.algorithm.leetcode.二分查找太细节了;

public class LC搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int m = l+((r-l)>>1);
            if(nums[m]>=nums[l]){
                if(target == nums[l])return l;
                if(target == nums[m])return m;
                if(target>nums[l] && target<nums[m]){
                    r = m-1;
                }else{
                    l = m+1;
                }
            }else {
                if(target == nums[r])return r;
                if(target == nums[m])return m;
                if(target>nums[m]&&target<nums[r]){
                    l = m+1;
                }else {
                    r = m-1;
                }
            }
        }
        return -1;
    }
}
