package com.dragon.力扣.数组和字符串;

public class C装水最多 {
    //暴力
    public int maxArea(int[] height) {
        int len = height.length;
        int max = -1;
        for(int i = 0;i<len;i++){
            for(int j = i+1;j<len;j++){
                max  = Math.max((j-i)*Math.min(height[i],height[j]),max);
            }
        }
        return max;
    }

    //双指针
    public int maxArea1(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }
}
