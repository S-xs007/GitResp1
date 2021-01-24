package cn.algorithm.leetcode.数学问题;

public class OFFER两个只出现一次的数字 {
    public int[] singleNumbers(int[] nums) {
        int tmp = 0;
        for (int num: nums) {
            tmp ^= num;     //tem =a^b
        }
        int div = 1;
        while ((div & tmp) == 0) {  //找到最后一个1   (异或==1说明不相同，相同位0)   按照这位进行分组
            div <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int num: nums) {
            if ((div & num) == 0) {     //该位时0的
                a ^= num;
            }
            else {                      //改为是1的
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

}
