package com.dragon.力扣.动态规划;

public class OFFER斐波那契数列 {
    //方法一  动态规划
    public int fib(int n) {
        int n1 = 0, n2 = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (n1 + n2) % 1000000007;
            n1 = n2;
            n2 = sum;
        }
        return n1;
    }

    //方法二  矩阵快速幂
    public static int f3(int n){
        if(n<1){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        int[][] base = {{1,1},{1,0}};
        int[][] res = dp1(base,n-2);
        return res[0][0]+res[1][0];
    }
    //求矩阵的n次幂
    public static int[][] dp1(int[][] m,int n){
        int[][] res = new int[m.length][m[0].length];
        for(int i = 0;i<res.length;i++){
            res[i][i] = 1;
        }
        int[][] tem = m;
        for(;n!=0;n>>=1){
            if((n & 1)!=0){
                res = muliMatrix(res,tem);
            }
            tem = muliMatrix(tem,tem);
        }
        return res;
    }

    //两个矩阵相乘
    public static int[][] muliMatrix(int[][] x1,int[][] x2){
        int[][] res = new int[x1.length][x2.length];
        for(int i = 0;i<x1.length;i++){
            for(int j = 0;j<x2[0].length;j++){
                for(int k = 0;k<x2.length;k++){
                    res[i][j] += x1[i][k] * x2[k][j];
                }
            }
        }
        return res;
    }






}
