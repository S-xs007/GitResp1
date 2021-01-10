package cn.bzqz.leetcode.二分查找太细节了;

public class LC搜索长度未知的数组 {
   /* public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) return 0;

        // 寻找二分查找的范围
        int left = 0, right = 1;
        while (reader.get(right) < target) {
            left = right;
            right <<= 1;
        }

        // binary search
        int pivot, num;
        while (left <= right) {
            pivot = left + ((right - left) >> 1);
            num = reader.get(pivot);

            if (num == target) return pivot;
            if (num > target) right = pivot - 1;
            else left = pivot + 1;
        }

        // there is no target element
        return -1;
    }
*/
}
