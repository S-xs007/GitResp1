package com.dragon.力扣.动态规划;

public class P爬楼梯 {
    //爬楼梯
    public int climbStairs(int n) {
        if(n==3){
            return 3;
        }
        if(n==2){
            return 2;
        }
        if(n==1){
            return 1;
        }
        int pre = 2;
        int next = 3;
        for(int i = 4;i<=n;i++){
            int tem = pre+next;
            pre = next;
            next = tem;
        }
        return next;
    }
}
