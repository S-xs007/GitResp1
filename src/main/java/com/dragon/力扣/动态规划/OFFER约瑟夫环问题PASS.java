package com.dragon.力扣.动态规划;

public class OFFER约瑟夫环问题PASS {
    public int lastRemaining(int n, int m) {
        int pre = 0;    //1的人的时候下表是0
        for(int i = 2;i<=n;i++){    //2个人的下标  3个人的下标   。。。
            pre = (pre+m)  %i;  //向右m次，然后超过了要对 当前人数取余
        }
        return pre;
    }



}
