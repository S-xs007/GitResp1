package com.dragon.力扣.数学问题;

public class OFFER二进制中一的个数 {
    public int hammingWeight(int n) {
        int result = 0;
        while(n!=0){
            result += n&1;
            n >>>= 1;   //题目要求为无符号数，则使用无符号位移
        }
        return result;
    }
}
