package cn.algorithm.leetcode.动态规划;

/**
 * 状态转移方程：
 * 当 i≥2 时，假设对正整数 i 拆分出的第一个正整数是 j（1≤j<i），则有以下两种方案：
 *
 * 将 i 拆分成 j 和 i−j 的和，且 i−j 不再拆分成多个正整数，此时的乘积是 j×(i−j)；
 * 将 i 拆分成 j 和 i−j 的和，且 i−j 继续拆分成多个正整数，此时的乘积是 j×dp[i−j]。
 *
 *
 *给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，
 * 此时得到的最大乘积是18
 *
 *
 */
public class OFFER剪绳子 {


    //利用数学方法（就以三为基准）
    public int integerBreak(int n) {
        if(n<=3)return n-1;
        int duanshu = n/3;  //看看分成几个三
        int yushu = n%3;    //看看能不能整除
        if(yushu==0){
            return (int) Math.pow(3,duanshu);
        }else if(yushu==1){
            return (int) Math.pow(3,duanshu-1)*4;
        }else {
            return (int) Math.pow(3,duanshu)*2;
        }
    }

    // 剪绳子2（涉及到大数取余的问题）
    public int cuttingRope1(int n) {
        if(n <= 3) return n - 1;
        long res=1L;
        int p=(int)1e9+7;
        //贪心算法，优先切三，其次切二
        //4的话最大就是2x2
        while(n>4){
            res=res*3   %p;//防止溢出，需要取余
            n-=3;
        }
        //出来循环只有三种情况，分别是n=2、3、4
        return (int)(res*n    %p);
    }

    //动态规划时间复杂度高
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {  //2---n-1  2开始才可以划分
            for (int j = 1; j < i; j++) {
                dp[i]= Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }           //                  i-j 不在继续拆分了       继续差分 i-j
        }
        return dp[n];
    }


    // 剪绳子2（涉及到大数取余的问题）
    public int cuttingRope111(int n) {
        if(n<=3)return n-1;
        long res = 1l;
        int p = 1000000007;
        while(n>4 ){
            res = res*3%p;
            n-=3;
        }
        return (int)(res*n%p);
    }
}
