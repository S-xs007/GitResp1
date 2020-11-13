package com.dragon.力扣.字节跳动;

import java.util.Deque;
import java.util.LinkedList;

public class J接雨水 {
    /**
     * 暴力解法，3曾循环，对于每一个元素，找到左边最大的，和右边最大的，然后选择一个较小的，较小的-当前元素就是当前元素的装水量
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    /**
     * 动态编程：空间换事件，就事先计算好每个位置左面和右边的最大值
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int ans = 0;
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {            //保存左边最大值数组
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {       //保存右边最大值数组
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }

        for (int i = 1; i < size - 1; i++) {        //开始计算结果
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }

    /**
     * 单调栈
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int ans = 0, index = 0;
        Deque<Integer> stack = new LinkedList<Integer>();

        //单调递减
        //一旦出现大于的，就开始处理
        while (index < height.length) {
            while (!stack.isEmpty() && height[index] > height[stack.peek()]) {  //如果栈顶<当前
                int top = stack.pop();  //左右边界height[index]，height[stack.peek()]
                if (stack.isEmpty()) break;
                int distance = index - stack.peek() - 1;
                int bounded_height = Math.min(height[index], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(index++);
        }


        return ans;
    }

    /**
     * 绝妙双指针
     * @param height
     * @return
     */
    public int trap4(int[] height) {
        int left = 0, right = height.length - 1;        //初始化双指针
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {         //左指针位置<右指针位置
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }




}
