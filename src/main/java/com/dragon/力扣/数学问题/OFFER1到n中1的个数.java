package com.dragon.力扣.数学问题;

public class OFFER1到n中1的个数 {
        //地推
        public int countDigitOne(int n) {
            int digit = 1, res = 0;
            int high = n / 10, cur = n % 10, low = 0;
            while(high != 0 || cur != 0) {
                if(cur == 0) res += high * digit;
                else if(cur == 1) res += high * digit + low + 1;
                else res += (high + 1) * digit;
                low += cur * digit;//地位
                cur = high % 10;//当前位
                high /= 10;     //得到高位
                digit *= 10;    //
            }
            return res;
        }
}
class Solution {
    public int countDigitOne(int n) {
        return f(n);
    }
    //递归
    private int f(int n ) {
        if (n <= 0)
            return 0;
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int) Math.pow(10, s.length()-1);
        int last = n - high*pow;
        if (high == 1) {
            return f(pow-1) + last + 1 + f(last);
        } else {
            return pow + high*f(pow-1) + f(last);
        }
    }
}
