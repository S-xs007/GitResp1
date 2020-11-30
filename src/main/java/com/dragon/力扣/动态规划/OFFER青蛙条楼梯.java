package com.dragon.力扣.动态规划;

public class OFFER青蛙条楼梯 {
    public int numWays(int n) {
        int n1 = 1, n2 = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (n1 + n2) % 1000000007;
            n1 = n2;
            n2 = sum;
        }
        return n1;
    }
}
