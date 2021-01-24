package cn.algorithm.leetcode.链表;

public class LC寻找重复数 {
    //方法1 一个萝卜一个坑
    public int findDuplicate(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == i+1){
                continue;
            }
            while(nums[i]!=i+1){
                if(nums[i]!=nums[nums[i]-1]){
                    swap(nums,i,nums[i]-1);
                }else {
                    return nums[i];
                }

            }
        }
        return -1;
    }
    public void swap (int[] nums,int i ,int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

    //二分
    public int findDuplicate2(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
            // 在 Java 里可以这么用，当 left + right 溢出的时候，无符号右移保证结果依然正确
            int mid = left+((right-left)>>1);
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }
            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
            // 此时重复元素一定出现在 [1, 4] 区间里
            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
