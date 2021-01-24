package cn.algorithm.leetcode.动态规划.背包DP;

/**
 * 一条包含字母A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 题目数据保证答案肯定是一个 32 位的整数。
 *
 *  有点类似于数字翻译成数组
 */
public class LC91_解码方法 {
    public static int numDecodings(String s) {

        if(s.length()==0 || s.charAt(0)=='0'        //只有10 20才可以被翻译
                || s.contains("00")
                || s.contains("30")
                || s.contains("40")
                || s.contains("50")
                || s.contains("60")
                || s.contains("70")
                || s.contains("80")
                || s.contains("90")){
            return 0;
        }

        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<=s.length();i++){

            if(s.charAt(i-1)=='0'){ //0 只能和前面的在一起
                dp[i] = dp[i-2];

            } else if(s.substring(i-2,i).compareTo("10")>0&&s.substring(i-2,i).compareTo("26")<=0){
                dp[i] = dp[i-1]+dp[i-2];    //可以一起翻译
            }else{
                dp[i] = dp[i-1];    //不能一起翻译
            }
        }
        return dp[s.length()];
    }

}
