package cn.algorithm.leetcode.动态规划.序列DP.最大子序列和;

import java.util.Arrays;

public class LC环形数组的最大子序和 {
    //结果就是  整个数组的和-不包含头尾的最小自诩和   整个数组的最大自诩和
    public int maxSubarraySumCircular(int[] A) {
        if (A.length == 1) return A[0];
        int sum = 0;
        for (int val : A) sum += val;
        return Math.max(maxSubarraySum(A), sum - minSubarraySum(A));
    }
    private int maxSubarraySum(int[] A) {   //包含头尾的最大子序和
        int res = A[0], sum = A[0];
        for (int i = 1; i < A.length; i++) {
            sum = Math.max(sum + A[i], A[i]);
            res = Math.max(res, sum);
        }
        return res;
    }
    private int minSubarraySum(int[] A) {   //不包含头尾的最小子序和
        int res = A[1], sum = A[1];
        for (int i = 2; i < A.length - 1; i++) {
            sum = Math.min(sum + A[i], A[i]);
            res = Math.min(res, sum);
        }
        return res;
    }
}
