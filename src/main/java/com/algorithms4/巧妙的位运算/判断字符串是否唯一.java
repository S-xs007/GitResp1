package com.algorithms4.巧妙的位运算;

//ASCLL字符一共128个，用两个64位的long类型正好
//0 没出现过  1  出现过
public class 判断字符串是否唯一 {
    public boolean isUnique(String astr) {
        long low64 = 0;
        long high64 = 0;

        for (char c : astr.toCharArray()) {
            if (c >= 64) {
                long bitIndex = 1L << (c - 64);
                if ((high64 & bitIndex) != 0) {     //原位置必须是0才行
                    return false;
                }

                high64 |= bitIndex;
            } else {
                long bitIndex = 1L << c;
                if ((low64 & bitIndex) != 0) {
                    return false;
                }

                low64 |= bitIndex;
            }

        }

        return true;
    }
}
