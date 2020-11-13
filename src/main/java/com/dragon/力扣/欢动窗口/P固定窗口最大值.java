package com.dragon.力扣.欢动窗口;

import java.util.Deque;
import java.util.LinkedList;

public class P固定窗口最大值 {


    /**
     * 滑动窗口问题规则：
     * 1.队列为空，可以直接尾部添加
     * 2.队列不为空，必须小于队列尾部才能添加，否则把队列尾部弹出
     *
     * 3.开始处理过期，从头部弹出
     *
     * 4.处理问题
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==0)return new int[0];
        Deque<Integer> window = new LinkedList<>();    //双端队列作窗口
        int[] res = new int[nums.length-k+1];           //每个窗口的最大值

        int index = 0;
        for(int i = 0;i < nums.length;i++){
            while(!window.isEmpty()&&nums[window.peekLast()]<=nums[i]){
                window.pollLast();                      //队列非空，且窗口last小就一直弹出去，直到大于才能加到队列
            }
            window.addLast(i);

            if(window.peekFirst()==i-k){            //看看头部是不是要过期
                window.pollFirst();
            }

            if(i>=k-1){                                 //窗口到了w的规模，开始收集答案
                res[index++] = nums[window.peekFirst()];
            }
        }
        return res;
    }

    /**
     *
     * @param nums
     * @param num
     * @return
     */
    public int subNumber(int[] nums,int num){
        Deque<Integer> window = new LinkedList<>(); //滑动窗口

        int count = 0;
        for(int i = 0;i< nums.length;i++){
            while(window.isEmpty()||(nums[i]-nums[window.peekFirst()])>=num){     //添加逻辑
                window.addLast(i);    //满足条件就加入，然后数组递增
            }
            count = window.peekLast()+1-window.peekFirst();//累加
            while(!window.isEmpty()&&(nums[window.peekLast()]-nums[window.peekFirst()])<num){
                window.pollFirst();
            }
        }
        return count;
    }





}
