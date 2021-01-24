package cn.algorithm.leetcode.字符串;

import java.util.*;

/**
 * @author coder01
 */
public class LC187重复的DNA序列 {
    /**
     * 方法1，滚动hush
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10, n = s.length();
        if (n <= L) {
            return new ArrayList();
        }
        // 将字符串序列转化为数组
        Map<Character, Integer> toInt = new
                HashMap() {{put('A', 0); put('C', 1); put('G', 2); put('T', 3); }};
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i) {
            nums[i] = toInt.get(s.charAt(i));
        }

        int a = 4, aL = (int)Math.pow(a, L);
        int h = 0;
        //seen存放出现过的hash值
        Set<Integer> seen = new HashSet();
        //存放结果集
        Set<String> output = new HashSet();
        for (int start = 0; start < n - L + 1; ++start) {
            //1.计算特征值
            if (start == 0){
                for(int i = 0; i < L; ++i) {
                    h = h * a + nums[i];
                }
            }
            else{
                h = h * a - nums[start - 1] * aL + nums[start + L - 1];

            }
            //2.如果特征值在seen出现过，就加入到结果集中
            if (seen.contains(h)) {
                output.add(s.substring(start, start + L));
            }
            //3.存储特征值
            seen.add(h);
        }
        return new ArrayList<String>(output);
    }

    /**
     * 方法二，位运算
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences1(String s) {
        int L = 10, n = s.length();
        if (n <= L) {
            return new ArrayList();
        }

        int a = 4, aL = (int)Math.pow(a, L);
        Map<Character, Integer> toInt = new
                HashMap() {{put('A', 0); put('C', 1); put('G', 2); put('T', 3); }};
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i) {
            nums[i] = toInt.get(s.charAt(i));
        }

        int bitmask = 0;
        Set<Integer> seen = new HashSet();
        Set<String> output = new HashSet();
        for (int start = 0; start < n - L + 1; ++start) {
            if (start != 0) {
                bitmask <<= 2;//去掉最后两位
                bitmask |= nums[start + L - 1];//添加最前面两位
                //细节，将2L位和2L+1位置为0
                bitmask &= ~(3 << 2 * L);
            }
            else {
                for(int i = 0; i < L; ++i) {
                    bitmask <<= 2;
                    bitmask |= nums[i];
                }
            }
            // update output and hashset of seen sequences
            if (seen.contains(bitmask)) output.add(s.substring(start, start + L));
            seen.add(bitmask);
        }
        return new ArrayList<String>(output);
    }
}
