package cn.bzqz.leetcode.左神;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class GP绳子覆盖问题 {
    public static int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;
        int index = left;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                index = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid + 1; // 注意
            }
        }
        return index;
    }
    public static int num(int[] nums,int k){
       int res = 0;
       for(int i = 0;i<nums.length;i++){
           int right = left_bound(nums,nums[i]+k);
           res = right-i >res? right-i : res;
       }
       return res;
    }
    //利用滑动窗口
    public static int num1(int[] nums,int k){
        int res = 0;
        Deque<Integer> deque = new LinkedList<>();
        for(int i =0;i<nums.length;i++){
            int right = i+k;
            if(!deque.isEmpty()){
                deque.pollFirst();
            }
            int j = deque.isEmpty()?i : deque.peekLast();
            while(j<nums.length){
                if(nums[j]<=right){
                    deque.offerLast(j++);
                }else {
                    break;
                }
            }
            res = Math.max(res,deque.peekLast()-deque.peekFirst()+1);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,5,6,7,8,11,14,16,37};
        int k = 9;
        System.out.println(num1(nums,k));
    }
}
