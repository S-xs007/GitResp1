package com.dragon.力扣.数学问题;

public class OFFER二进制中一的个数 {
    //
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            if((n&1)==1){
                count++;
            }
            n >>>=1; //无符号右移
        }
        return count;
    }
}
