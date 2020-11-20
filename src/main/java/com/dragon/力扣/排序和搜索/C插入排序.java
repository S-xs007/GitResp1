package com.dragon.力扣.排序和搜索;

public class C插入排序 {
    public static void chaRuSort(int[] x) {
        int len = x.length;
        for (int i =1 ; i < len; i++) { //0-i内有序
            for (int j = i; j >0 ; j--) {

                //前面大就交换
                if (x[j] < x[j - 1]) {
                    int tem = x[j-1];
                    x[j-1] = x[j];
                    x[j] = tem;
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] x = {1, 4, 2, 5, 3, 4};
        chaRuSort(x);
        for (int i : x) {
            System.out.println(i);
        }
    }
}
