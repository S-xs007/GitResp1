package cn.algorithm.leetcode.排序和搜索;

public class OFFER旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        while(left<right){
            int mid = left+((right-left)>>1);
            int tem = numbers[mid];
            if (numbers[mid] < numbers[right]) {    //右边是递增，就往左走
                right = mid;
            } else if (numbers[mid] > numbers[right]) { //右边有问题，往右走
                left = mid + 1;
            } else {    //中间等于最右边   就往左走一步
                right -= 1;
            }
        }
        return numbers[left];
    }
}
