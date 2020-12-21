package cn.bzqz.leetcode.数组;

import java.util.HashMap;
import java.util.Map;

public class LC数组中每个数第一次出现的位置 {
    //第一次的位置
    public int[] find_left_repeat_num(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        int[] res = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){  //第一次出现
                res[i] = -1;
                map.put(nums[i],i );
            }else {
                res[i] = map.get(nums[i]);
            }
        }
        return res;
    }
    //前一次的位置
    public int[] find_left_repeat_numII(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        int[] res = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){  //第一次出现
                res[i] = -1;
            }else {
                res[i] = map.get(nums[i]);
            }
            map.put(nums[i],i );
        }
        return res;
    }













}
