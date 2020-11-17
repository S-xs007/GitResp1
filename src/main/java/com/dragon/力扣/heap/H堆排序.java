package com.dragon.力扣.heap;

import java.util.Arrays;

/**
 * 堆排序
 */
public class H堆排序 {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




    public static void heapSort(int[] arr){
        //构造大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--){
            adjustHeap(arr, i, arr.length);
        }
        //堆顶元素与堆尾元素作交换
        for (int j = arr.length - 1; j >= 0; j--){
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }
    }

    //从begin开始下降
    public static void adjustHeap(int[] arr, int begin, int end){
        for (int i = 2 * begin + 1; i < end; i=2*begin+1){
            //如果右孩子比左孩子大就将指针指向右孩子
            if(i + 1 < end && arr[i] < arr[i + 1]){
                i++;
            }
            //如果父亲节点比孩子节点小则交换它们的位置,并且将指针指向孩子节点,下一步继续构造以孩子节点为根节点的大顶堆
            if(arr[begin] < arr[i]){
                swap(arr, begin, i);
                begin = i;
            }else{
                //父节点比左右孩子节点都大,则说明已经符合大顶堆的要求
                break;
            }
        }
    }




    public static void main(String[] args) {
        int[] arr = new int[]{33, 35, 41, 26, 78};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}