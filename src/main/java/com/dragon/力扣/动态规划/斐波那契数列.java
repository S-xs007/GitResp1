package com.dragon.力扣.动态规划;

public class 斐波那契数列 {
    public static void main(String[] args) {
        System.out.println(fb(4));
        System.out.println(db(4));
    }
    //方法1 直接递归
    public static int fb(int n){
        if(n==1)return 1;
        if(n==2)return 1;
        return fb(n-1)+fb(n-2);
    }

    //方法二  动态规划
    public static int db(int n){
        int pre = 1;
        int cur = 1;
        for(int i = 3;i<=n;i++){
            int tem = pre+cur;
            pre = cur;
            cur = tem;
        }
        return cur;
    }

    //方法三  矩阵快速幂
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
