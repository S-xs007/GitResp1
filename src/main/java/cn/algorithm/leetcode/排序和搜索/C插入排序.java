package cn.algorithm.leetcode.排序和搜索;
/**
 * @Author: zxS
 * @Date: 11:44 2020/11/27
 * @Description：保持0-i的有序
 */
public class C插入排序 {

    public static void swap(int[] nums,int i,int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }


    public static void chaRuSort1(int[] nums) {
        int len = nums.length;
        for(int i = 0;i < len;i++){
            for(int j = i;j >= 1;j--){  //从i往前走
                if(nums[j]<nums[j-1]){
                    swap(nums,j,j-1);
                }
            }
        }
    }
}
