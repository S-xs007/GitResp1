package cn.algorithm.leetcode.字符串;

import java.util.HashSet;

public class LC1044最长重复子串 {
    public int search(int L, int a, long modulus, int n, int[] nums) {

        long h = 0;
        for (int i = 0; i < L; ++i) {
            h = (h * a + nums[i]) % modulus;
        }
        HashSet<Long> seen = new HashSet();
        seen.add(h);
        long aL = 1;

        for (int i = 1; i <= L; ++i) {
            aL = (aL * a) % modulus;
        }

        for (int start = 1; start < n - L + 1; ++start) {
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + L - 1]) % modulus;
            if (seen.contains(h)) {
                return start;
            }
            seen.add(h);
        }
        return -1;
    }

    public String longestDupSubstring(String S) {
        //1.将给定的子符串--->数字数组 26个英文字母对应 0-25
        int n = S.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = (int)S.charAt(i) - (int)'a';
        }
        //Rabin-Karp 算法 基准值
        int a = 26;
        //滚动哈希函数的模数值，以避免溢出
        long modulus = (long)Math.pow(2, 32);

        // 二分查找, L = 重复字符串的长度
        int left = 1, right = n;
        int L;
        while (left != right) {
            L = left + (right - left) / 2;
            if (search(L, a, modulus, n, nums) != -1) {
                left = L + 1;
            }
            else {
                right = L;
            }
        }

        int start = search(left - 1, a, modulus, n, nums);
        return start != -1 ? S.substring(start, start + left - 1) : "";
    }
}


