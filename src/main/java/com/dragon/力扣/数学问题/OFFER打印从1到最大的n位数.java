package com.dragon.力扣.数学问题;

import java.util.ArrayList;
import java.util.List;

public class OFFER打印从1到最大的n位数 {
    //不考虑大数问题的解法XXX
    /*public int[] printNumbers(int n) {
        int end = (int)Math.pow(10, n) - 1;//999
        int[] res = new int[end];
        for(int i = 0; i < end; i++)
            res[i] = i + 1;
        return res;
    }*/
    private List<Integer> list;
    //全排列
    public int[] printNumbers(int n) {
        list = new ArrayList<>();
        dfs(n, 0, new StringBuilder());
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(int n, int i, StringBuilder sb) {
        if (i == n) {
            while (sb.length() != 0 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            if (sb.length() != 0) {
                list.add(Integer.valueOf(sb.toString()));
            }
            return;
        }
        for (int j = 0; j < 10; j++) {
            sb.append(j);
            dfs(n, i + 1, sb);
            if (sb.length() != 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
