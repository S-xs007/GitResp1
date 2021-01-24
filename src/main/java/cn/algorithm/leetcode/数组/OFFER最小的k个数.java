package cn.algorithm.leetcode.数组;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
/**
 * @Author: zxS
 * @Date: 14:07 2020/11/27
 * @Description：
 * 时间复杂度：O(nlogk)，其中 n 是数组 arr 的长度。由于大根堆实时维护前 k 小值，所以插入删除都是 O(logk)的时间复杂度，最坏情况下数组里 n 个数都会插入，所以一共需要 O(nlogk) 的时间复杂度。
 * 空间复杂度：O(k)O(k)，因为大根堆里最多 kk 个数。
 *
 */
public class OFFER最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        if(k==0)return res;
        //大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i = 0;i<k;i++){     //先放前k个数
            queue.add(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            res[i] = queue.poll();
        }
        return res;

    }
}
