package com.dragon.力扣.数组和字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/**
 * @Author: zxS
 * @Date: 12:34 2020/11/20
 * @Description：一个萝卜一个坑，遍历每一个萝卜，找到自己的坑，如果这个坑被另一个自己占用了，就说明重复了
 */
public class OFFER数组中的重复数字 {
    public int findRepeatNumber(int[] nums) {
        int tem = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != i) {  //只要不是自己的坑
                if (nums[i] == nums[nums[i]]) { //相等就说明重复了
                    return nums[i];
                }
                tem = nums[i];  //交换两个坑的萝卜
                nums[i] = nums[tem];
                nums[tem] = tem;
            }
        }
        return -1;
    }
}
