package com.dragon.力扣.数学问题;

import java.util.Arrays;

public class OFFER把数组拍成最小的数 {
        public String minNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for(int i = 0; i < nums.length; i++)
                strs[i] = String.valueOf(nums[i]);
            fastSort(strs, 0, strs.length - 1); //自定义排序
            StringBuilder res = new StringBuilder();
            for(String s : strs)
                res.append(s);
            return res.toString();
        }
        void fastSort(String[] strs, int l, int r) {        //类似快速排序
            if(l >= r) return;
            int i = l, j = r;
            String tmp = strs[i];
            while(i < j) {
                while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;  //从右边找一个小的
                while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;  //从左边找到一个大的
                tmp = strs[i];
                strs[i] = strs[j];      //交换
                strs[j] = tmp;
            }
            strs[i] = strs[l];
            strs[l] = tmp;
            fastSort(strs, l, i - 1);
            fastSort(strs, i + 1, r);
        }

        //利用内置排序函数
    public String minNumber1(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
}
