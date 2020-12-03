package cn.bzqz.leetcode.动态规划.背包DP;

public class LC70_爬楼梯 {
    public int climbStairs(int n) {
        int pre = 0;
        int cur = 1;    //0层楼梯 ，一种可能
        for(int i = 1;i<=n;i++){
            int tem = pre+cur;
            pre = cur;
            cur = tem;
        }
        return cur;
    }
}
