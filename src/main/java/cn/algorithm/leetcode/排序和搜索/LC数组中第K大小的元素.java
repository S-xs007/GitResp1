package cn.algorithm.leetcode.排序和搜索;

import java.util.Random;

public class LC数组中第K大小的元素 {
}
//利用改进的快速排序
class Solution {
    Random random = new Random();
    public int findKthLargest1(int[] nums, int k) { //主函数
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSort(int[] nums, int l, int r, int target) {
        int position = random.nextInt(r-l+1)+l; //得到基准值
        swap(nums,position,r);  //基准值放到最右边
        int key = nums[r];  //基准
        int i = l;
        for(int j = l;j<r;j++){
            if(nums[j]<=key){
                swap(nums,j,i++);
            }
        }
        swap(nums,i,r);
        int finish = i;
        if(finish == target)return nums[target];
        else {
            return finish<target?quickSort(nums,finish+1,r,target):quickSort(nums,l,finish-1,target);
        }
    }
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
//利用堆排序
class Solution11 {
    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
        return nums[0];
    }
    //构造一个大根堆
    public  void buildHeap(int[] arr){
        for (int i = arr.length / 2-1; i >= 0; i--){
            adjustHeap(arr, i, arr.length);
        }
    }

    public  void adjustHeap(int[] arr, int begin, int end){
        for (int i = 2 * begin + 1; i < end; i=2*begin+1){//从左节点开始
            if(i + 1 < end && arr[i] < arr[i + 1]){
                i++;
            }
            if(arr[begin] < arr[i]){
                swap(arr, begin, i);
                begin = i;
            }else{
                break;
            }
        }
    }
    public  void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}