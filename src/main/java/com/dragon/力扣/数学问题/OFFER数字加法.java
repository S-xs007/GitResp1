package com.dragon.力扣.数学问题;

public class OFFER数字加法 {
    public int sumNums(int n) {
        // 其中 tmp 和 (n += sumNums(n - 1)) > 0 中的大于0条件都是为了做短路运算符合语法要求加的，并没有实际意义
        boolean tmp = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

}
