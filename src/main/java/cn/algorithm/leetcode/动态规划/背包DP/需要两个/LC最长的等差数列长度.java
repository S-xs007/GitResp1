package cn.algorithm.leetcode.动态规划.背包DP.需要两个;

import java.util.*;

public class LC最长的等差数列长度 {
        public int longestArithSeqLength(int[] A) {
            int len = A.length;
            Map<Integer, List<Integer>> map = new HashMap<>(len);
            for (int i = 0; i < len; ++i)
                map.computeIfAbsent(A[i], unused -> new ArrayList<>()).add(i);

            int res = 0, count = 2;
            for (int i = 0; i < len - res; ++i) {
                for (int j = i + 1; j < len - res + 1; ++j) {
                    int diff = A[j] - A[i];
                    if (diff == 0) {
                        res = Math.max(res, map.get(A[i]).size());
                        continue;
                    }
                    int next = A[j] + diff, last_idx = j;
                    while (map.containsKey(next)) {
                        List<Integer> temp_list = map.get(next);
                        last_idx = -(Collections.binarySearch(temp_list, last_idx) + 1);
                        if (last_idx == temp_list.size())
                            break;
                        last_idx = temp_list.get(last_idx);
                        ++count;
                        next += diff;
                    }
                    res = Math.max(res, count);
                    count = 2;
                }
            }
            return res;
        }
    }

