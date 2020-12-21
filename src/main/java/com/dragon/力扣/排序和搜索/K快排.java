package com.dragon.力扣.排序和搜索;

import java.util.Stack;

/**
 * 快速排序演示
 * 核心思想就是：
 * 先从右边开始扫描，找到第一个小然后交换
 * 再从左边扫描，找到第一个大的进行交换
 * 知道左边的指针遇到右边指针就退出
 *
 * 然后对左边和右边进行上述操作
 */
public class K快排 {
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int key = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= key) {
                r--;
            }
            swap(nums, l, r);
            while (l < r && nums[l] <= key) {
                l++;
            }
            swap(nums, l, r);
        }
        quickSort(nums, 0, l - 1);
        quickSort(nums, r + 1, right);

    }

    public static void swap(int[] nums, int l, int r) {
        int tem = nums[l];
        nums[l] = nums[r];
        nums[r] = tem;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 3, 5, 3, 5, 32, 1, 7, 2};
        quickSort1(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
//非递归版
    static private void quickSort1(int array[], int start, int end) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        stack.push(end);
        int key;

        while (!stack.isEmpty()) {
            //从栈中取出起始位置和终止位置
            int _end = stack.pop();
            int _start = stack.pop();
            key = array[_start];    //设立基准点
            int l = _start;
            int h = _end;
            //开始一轮快排
            while (l < h) {
                //右边找一个小的，左边找一个大的交换
                while (array[h] >= key && l < h)
                    h--;
                while (array[l] <= key && l < h)
                    l++;
                if (l < h) {
                    swap(array,h,l);
                }
            }

            if (key > array[l]) {   //如果基准点 >
                int temp = array[_start];
                array[_start] = array[l];
                array[l] = temp;
            }

            if (_start < l - 1) {
                stack.push(_start);
                stack.push(l - 1);
            }
            if (_end > l + 1) {
                stack.push(l + 1);
                stack.push(_end);
            }

        }


    }
}
