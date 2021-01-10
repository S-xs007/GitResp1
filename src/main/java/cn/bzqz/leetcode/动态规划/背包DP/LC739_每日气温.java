package cn.bzqz.leetcode.动态规划.背包DP;

//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
// 如果气温在这之后都不会升高，请在该位置用0 来代替。
//
//例如，给定一个列表temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是[1, 1, 4, 2, 1, 1, 0, 0]。

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LC739_每日气温 {
    //暴力
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Arrays.fill(res,0);
        for(int i =0;i<T.length;i++){
            for(int j = i+1;j<T.length;j++){
                if(T[j]>T[i]){
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }
    //单调栈
    public static int[] dailyTemperatures1(int[] T) {
        int[] res = new int[T.length];
        Arrays.fill(res,0);
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0;i<T.length;i++){
            while(!deque.isEmpty() && T[i]>T[deque.peekLast()]){
                int position = deque.pollLast();
                res[position] = i-position;
            }
            deque.offerLast(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = new int[]{73,74,75,71,69,72,76};
        int[] tem = dailyTemperatures1(num);
        for(int n:tem){
            System.out.println(n);
        }
    }
}
