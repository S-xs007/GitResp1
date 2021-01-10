package com.dragon.力扣.排序和搜索;

import java.util.Stack;

/**
 * 快速排序在一趟排序中将数字分割成为独立的两部分，
 * 左边一部分小于轴值，右边一部分大于轴值，轴值的选择理论上可以选择数组中的任何一个数组，
 * 我们在这里考虑选择第一个数字。然后对两部分序列重复进行上述操作，快速排序可以用递归来完成
 *
 * 时间复杂度：最好情况O(n*logn)——Partition函数每次恰好能均分序列，其递归树的深度就为.log2n.+1
 * （.x.表示不大于x的最大整数），即仅需递归log2n次；
 * 最坏情况O（n^2）,每次划分只能将序列分为一个元素与其他元素两部分，这时的快速排序退化为冒泡排序，
 * 如果用数画出来，得到的将会是一棵单斜树，也就是说所有所有的节点只有左（右）节点的树；平均时间复杂度O(n*logn)
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
    static private void quickSort1(int[] array, int start, int end) {
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
