package cn.algorithm.leetcode.位运算;

/**
 * @author coder01
 */
public class LC137只出现依次的数字Ⅱ {
    public int singleNumber(int[] nums) {
        int result = 0;
        //int 类型32位
        for(int i = 0;i < 32;i++){
            int count = 0;
            for(int num : nums){
                //num 右移可以， 1 左移不行
                count += 1 & num >> i;
            }
            result |= ((count % 3) << i);
        }
        return result;
    }

}
