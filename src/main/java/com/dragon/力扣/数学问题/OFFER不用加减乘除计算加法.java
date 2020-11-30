package com.dragon.力扣.数学问题;

public class OFFER不用加减乘除计算加法 {
    public int add(int a, int b) {
        while(b!=0){
            int carry = (a & b) << 1;
            a = a^b;    //无尽为相加
            b = carry;   //进位
        }
        return a;
    }
}
