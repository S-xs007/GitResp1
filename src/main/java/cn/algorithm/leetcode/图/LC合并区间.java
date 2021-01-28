package cn.algorithm.leetcode.图;


import java.util.*;

public class LC合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> list = new ArrayList<int[]>();
        for(int i = 0;i<intervals.length;i++){
            int L = intervals[i][0];
            int R = intervals[i][1];
            if(list.size() == 0 || list.get(list.size()-1)[1]<L){
                list.add(new int[]{L,R});
            }else {
                //合并
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],R);
            }
       }
       return list.toArray(new int[list.size()][]);
    }
}
