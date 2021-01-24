package cn.algorithm.leetcode.动态规划.背包DP;

import java.util.LinkedList;
import java.util.Queue;

public class LC55_跳跃游戏 {
    //简单
    public boolean canJump(int[] nums) {
        if(nums==null|| nums.length==0||nums.length==1){
            return true;
        }
        int len = nums.length;
        int maxLength = 0;
        for(int i = 0;i< nums.length;i++){
            if(maxLength>=i){   //可以调到这里
                int tem = i+nums[i];
                if(tem>= len-1)return true;
                maxLength = Math.max(maxLength,tem);
            }
        }
        return false;
    }

    //需要返回使用最少的跳跃次数
    //方法1，会超时
    //每次找到能到达的最靠前的那个位置
    //然后找到能到达上个位的的最靠前的位置，直到这个位置来到了开头
    public int jump(int[] nums) {
        int position = nums.length-1;
        int res = 0;
       while(position>0){
           for(int i = 0;i<position;i++){
               if(i+nums[i]>=position){
                   position = i;
                   res++;
                   break;
               }
           }
       }
       return res;
    }

    //方法2每次只从能跳最远的位置跳
    public int jump1(int[] nums) {
        int len = nums.length;
        int end = 0;//记录范围的结束位置，到了这个位置就要计算出这个范围里面最远跳到那里，无需直到从哪里调
        int maxPosition = 0;
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;  //更新范围
                res++;              //条一部
            }
        }
        return res;
    }

}
