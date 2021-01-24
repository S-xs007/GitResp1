package cn.algorithm.leetcode.数组;

public class OFFER调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        int index = 0;
        for(int i = 0;i<nums.length;i++){
            if((nums[i]&1)!=0){ //偶数
                int tem = nums[i];
                nums[i] = nums[index];
                nums[index++] = tem;
            }
        }
        return nums;
    }
}
