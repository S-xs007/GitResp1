package cn.algorithm.leetcode.动态规划.序列DP;

import java.util.Arrays;
import java.util.Comparator;

public class LC俄罗斯信封套娃问题 {

        public int lengthOfLIS(int[] nums) {    //标准LIS
            int[] dp = new int[nums.length];
            int res = 0;
            for(int num : nums) {
                int i = 0, j = res;
                while(i < j) {
                    int m = (i + j) / 2;
                    if (dp[m] < num) i = m + 1;
                    else j = m;
                }
                dp[i] = num;    //替换
                if (j == res) { //判断是不是增加长度
                    res++;
                }
            }
            return res;
        }

        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, new Comparator<int[]>() {
                public int compare(int[] arr1, int[] arr2) {
                    if (arr1[0] == arr2[0]) {       //w相同  按照h降序
                        return arr2[1] - arr1[1];
                    } else {                        //w不同按照w升序
                        return arr1[0] - arr2[0];
                    }
                }
            });
            int[] secondDim = new int[envelopes.length];
            for (int i = 0; i < envelopes.length; ++i) secondDim[i] = envelopes[i][1];
            //对 h 进行LIS
            return lengthOfLIS(secondDim);
        }
}
