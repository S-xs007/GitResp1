package cn.algorithm.leetcode.动态规划.序列DP;

import com.dragon.设计模式.并发编程之美.数据库连接池实现web服务器.DefaultThreadPool;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
//dp[i] 表示 i位置的最长上上升子序列个数
//dp[i] 0-i if(num[i]>num[j])dp[i] = max(dp[j]+1,dp[i])
//dp[0] = 1
public class LC300_最长上升子序列 {
    //方法1
    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
    //方法2（利用二分查找）
    public int lengthOfLIS3(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }//要么找到第一个大于num的位置  要不找到最后的空位置（num最大）
            tails[i] = num; //替换
            if(res == j) res++; //没找到，就说明num最大接在了后面，那么子串长度需要增加
        }
        return res;
    }
}
//[1,3,6,7,9,4,10,5,6]
//[10,9,2,5,3,7,101,18]