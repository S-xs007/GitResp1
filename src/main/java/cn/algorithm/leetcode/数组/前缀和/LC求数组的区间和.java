package cn.algorithm.leetcode.数组.前缀和;

import java.util.HashMap;
import java.util.Map;

public class LC求数组的区间和 {
    public int[] array_interval_sum(int[] nums, int[][] queries) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i< nums.length;i++){
            if(i==0){
                map.put(i,nums[i]);
                continue;
            }else {
                map.put(i,map.get(i-1)+nums[i]);
            }
        }
        int[] res = new int[queries.length];
        int index = 0;
        for(int[] tem:queries){
            res[index++] = map.get(tem[1]-1)-map.get(tem[0]-1)+nums[tem[0]-1];
        }
        return res;
    }

}
