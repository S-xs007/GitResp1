package cn.algorithm.leetcode.排序;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * @Author: zxS
 * @Date: 15:23 2020/11/18
 * @Description：
 */
public class LC会议室Ⅱ {

        public int minMeetingRooms(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }
            //最小堆（结束时间）
            PriorityQueue<Integer> allocator =
                    new PriorityQueue<Integer>(
                            intervals.length,
                            new Comparator<Integer>() {
                                public int compare(Integer a, Integer b) {
                                    return a - b;
                                }
                            });
            //按照开始时间升序
            Arrays.sort(
                    intervals,
                    new Comparator<int[]>() {
                        public int compare( int[] a,  int[] b) {
                            return a[0] - b[0];
                        }
                    });

            allocator.add(intervals[0][1]);//第一个加入

            for (int i = 1; i < intervals.length; i++) {
                //判断开始时间和队中的最小结束时间
                if (intervals[i][0] >= allocator.peek()) {  //可以公用，我开始时他已经结束了
                    allocator.poll();
                }

                allocator.add(intervals[i][1]); //把结束时间加进去
            }

            return allocator.size();
        }

}
