package com.dragon.力扣.动态规划;

public class OFFER约瑟夫环问题 {
    public int lastRemaining(int n, int m) {
        int pre = 0;
        for(int i = 2;i<=n;i++){    //2个人的下标  3个人的下标   。。。
            pre = (pre+m)%i;
        }
        return pre;
    }



}
