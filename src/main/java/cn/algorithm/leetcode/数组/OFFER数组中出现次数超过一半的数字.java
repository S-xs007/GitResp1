package cn.algorithm.leetcode.数组;
/**
 * @Author: zxS
 * @Date: 13:46 2020/11/27
 * @Description：摩尔投票法 求 众数
 */
public class OFFER数组中出现次数超过一半的数字 {
    //摩尔投票法   求众数
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;     //相同就加1  不同就减一   位0就重新选择
        }
        return x;
    }

}
