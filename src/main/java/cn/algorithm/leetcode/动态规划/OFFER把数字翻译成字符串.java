package cn.algorithm.leetcode.动态规划;
//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
// 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
//
//
//示例 1:
//
//输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
//
public class OFFER把数字翻译成字符串 {
    //状态转移方程  如果i自己翻译       dp[i] = dp[i-1]
    //            如果i和前面一起翻译  dp[i] = dp[i-1] + dp[i-2]

    public int translateNum1(int num) {
        //1.利用三个变量来优化动态规划需要的数组空间
        String str = String.valueOf(num);
        //  相当于i-1    i     i+1
        int pre = 0, cur = 1, next =1;  //从1开始，看看0和1能不能一起翻译  ，初始化i=0时，cur = 1，只有一种方案，就是0单独翻译
        for(int i = 1;i<str.length();i++){
            pre = cur;
            cur = next;
            String tem = str.substring(i-1,i+1);
            if(tem.compareTo("10")>=0&&tem.compareTo("25")<=0){
                //可以翻译
                next = cur+pre;//当前和前一个一起翻译
            }else {
                next = cur;     //单独翻译
            }
        }
        return next;
    }
}