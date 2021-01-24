package cn.algorithm.leetcode.数组;

public class H合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        int x2 = n-1;
        int x1 = m-1;
        while(x2>=0&&x1>=0){
            if(nums1[x1]<=nums2[x2]){
                nums1[index--] = nums2[x2--];
            }else {
                nums1[index--] = nums1[x1--];
            }
        }
        //把第二个数组剩下的复制到1中
        System.arraycopy(nums2, 0, nums1, 0, x2 + 1);
    }
}
