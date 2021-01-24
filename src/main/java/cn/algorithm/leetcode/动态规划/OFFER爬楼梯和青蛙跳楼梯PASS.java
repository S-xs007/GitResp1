package cn.algorithm.leetcode.动态规划;

public class OFFER爬楼梯和青蛙跳楼梯PASS {
    public int numWays(int n) {
        int pre = 0;
        int cur = 1;    //n==0  返回1
        for(int i = 1;i<=n;i++){    //从1开始计算
            int sum = (pre+cur)%1000000007; //爬楼梯就是不需要取余
            pre = cur;
            cur = sum;
        }
        return cur;
    }
}
