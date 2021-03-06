package cn.algorithm.leetcode.数组;

/**
 * 上面的方法不符合要求
 *
 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。

 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 */
public class S4寻找两个正序数组的中位数 {
    /**
     * 寻找两个数组中位数
     * 遍历k次，然后每次都是小的向前走一步
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int sum = m+n;
        int index1 = 0,index2 = 0;
        int left = 0;
        int right = 0;
        for(int i = 0 ;i<=sum/2;i++){
            left = right;   //记录中位数的前一个
            if(index1<m&&(index2>=n||nums1[index1]<nums2[index2])){
                right = nums1[index1++];    //记录中位数
            }else{
                right = nums2[index2++];
            }
        }
        if((sum&1)==0)return (left+right)/2.0;
        else return right;
    }
}
class Solution {
    /**
     * 利用二分法查找，就是查找两个有序数组中第k小的元素
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement1(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex = totalLength / 2;
            double median = (getKthElement1(nums1, nums2, midIndex) + getKthElement1(nums1, nums2, midIndex + 1)) / 2.0;
            return median;
        }
    }

    /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
     * 这里的 "/" 表示整除
     * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
     * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
     * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
     * 这样 pivot 本身最大也只能是第 k-1 小的元素
     * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
     * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
     * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
     */
    /**
     * 从两个排好序的数组中找到第k小的元素
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int getKthElement1(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int index1 = 0; //记录1的位置
        int index2 = 0; //记录2的位置
        while(true){
            //判断边界
            if(index1==n1)return nums2[index2+k-1]; //1走完了
            if(index2==n2)return nums1[index1+k-1]; //2走完了
            if(k==1)return Math.min(nums1[index1],nums2[index2]);   //找到k了
            int href = k/2; //二分
            int newIndex1 = Math.min(index1+href,n1)-1; //防止越界
            int newIndex2 = Math.min(index2+href,n2)-1; //防止越界
            int p1 = nums1[newIndex1];
            int p2 = nums2[newIndex2];
            if(p1<=p2){
                k -= (newIndex1 - index1 + 1);  //必须加一，k减去新增的距离，这部分已经是小的了
                index1 = newIndex1+1;
            }else{
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2+1;
            }
        }


    }

}
