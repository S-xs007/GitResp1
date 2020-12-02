package com.dragon.力扣.栈和队列;

import java.util.Deque;
import java.util.LinkedList;
/**
 * @Author: zxS
 * @Date: 12:47 2020/12/1
 * @Description：利用单调队列
 */
public class OFFER滑动窗口的最大值 {
    /**
     * 滑动窗口的最大值
     * @param nums  数组
     * @param k     窗口大小
     * @return      最大值数组
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0|| k==0)return new int[0];//判空
        Deque<Integer> deque = new LinkedList<>();//单调队列
        int[] res = new int[nums.length-k+1];
        for(int left = 1-k,right = 0;right< nums.length;left++,right++){
            if(left>0 && deque.peekFirst() == nums[left-1]){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[right]){
                deque.pollLast();
            }
            deque.offerLast(nums[right]);
            if(left>=0){
                res[left] = deque.peekFirst();
            }
        }
        return res;

    }

}
