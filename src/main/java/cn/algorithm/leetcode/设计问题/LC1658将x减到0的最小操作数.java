package cn.algorithm.leetcode.设计问题;

import java.util.HashMap;
import java.util.Map;

//1 1 4 2 3
//5
public class LC1658将x减到0的最小操作数 {
        public int minOperations(int[] nums, int x) {
            int len = nums.length;
            //前缀和
            int[] preSum = new int[len + 1];
            for (int i = 0; i < len; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
            //后缀和
            Map<Integer, Integer> map = new HashMap<>();
            int[] latterSum = new int[len + 1];
            map.put(0, 0);
            int idx = 1;
            for (int i = len - 1; i >= 0; i--) {
                latterSum[idx] = latterSum[idx - 1] + nums[i];
                map.put(latterSum[idx], idx);
                idx++;
            }
            if (preSum[len] < x || latterSum[len] < x) return -1;//避免多次计算
            int res = Integer.MAX_VALUE;

            for (int i = 0; i < len + 1; i++) {
                int pre = preSum[i];
                if (map.containsKey(x - pre)) {
                    res = Math.min(res, map.get(x - pre) + i);
                }
            }

            return res == Integer.MAX_VALUE ? -1 : res;

        }

}
