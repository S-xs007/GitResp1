package com.dragon.力扣.数学问题;
/**
 * @Author: zxS
 * @Date: 11:51 2020/11/28
 * @Description：
 * n==11
 * 1.确定n是几位数    2
 * 2.确定是该位数下的数字 10
 * 3.确定是哪一数位
 */
public class OFFER数字序列中某一位的数字 {
    public int findNthDigit(int n) {
            int digit = 1;      //位数    +=1
            long start = 1;     //对应位数的最小值  1  10  100  *=10
            long count = digit * 9 * start; // 该数位的数一共的索引个数（不是数字个数）
            while (n > count) {             // 1.找出 n 属于那个数位里的索引
                n -= count;         //1-9 10  10-99  90  100-999  900
                digit += 1;         //1  2   3    4
                start *= 10;        //1  10  100  1000
                count = digit * start * 9;
            }
        // 上面的循环结束后：
        // digit 等于原始的 n 所属的数位；start 等于原始的 n 所属数位的数的起始点
        // index_count 等于原始的 n 所属数位的索引总个数（不重要了，下面不用）
        // n 等于在当前数位里的第 n - 1 个索引（索引从 0 开始算起）
            long num = start + (n - 1) / digit;                         // 2.算出原始的 n 到底对应哪个数字
            return Long.toString(num).charAt((n - 1) % digit) - '0';    // 3.得到对应数字的对应位数
        //(n - 1) % digit）          这个就是对应数的第几位
        }
    }

