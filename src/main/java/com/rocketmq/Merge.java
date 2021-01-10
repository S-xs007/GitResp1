package com.rocketmq;



public class Merge {
    public static int[] mergeTwoArray(int[] arr1,int[] arr2){
        if(arr1 == null || arr1.length==0)return arr2;
        if(arr2 == null || arr2.length==0)return arr1;
        int index1 = 0;
        int index2 = 0;
        int len1 = arr1.length;
        int len2 = arr2.length;
        int index = 0;
        int[] res = new int[len1+len2];
        while (index1<len1 && index2<len2){
            res[index++] = arr1[index1]<=arr2[index2] ? arr1[index1++] : arr2[index2++];
        }
        while (index1<len1){    //如果1还有
            res[index++] = arr1[index1++];
        }
        while (index2<len2){    //如果2还有
            res[index++] = arr2[index2++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9,11,30,40,60};
        int[] arr2 = {2,4,6,8,10,10,11,13,144,665};
        int[] res = mergeTwoArray(arr1,arr2);
        for(int tem : res){
            System.out.print(tem);
            System.out.print("  ");
        }
    }
}
