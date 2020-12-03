package com.dragon.力扣.动态规划;

public class OFFER正则表达式匹配 {

    //递归版本
    public boolean isMatch1(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();//匹配串空了，要看一个字符串还有灭有
        boolean match = !s.isEmpty() && ((s.charAt(0) == p.charAt(0)) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*')
            return isMatch(s, p.substring(2)) || (match && isMatch(s.substring(1), p));
        return match && isMatch(s.substring(1), p.substring(1));
    }

    //优化版，动态规划
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {      //字符串从0开始，，
            for (int j = 1; j <= n; ++j) {  //匹配要看两个，因为*需要看两个
                if (p.charAt(j - 1) == '*') {       //*
                    f[i][j] = f[i][j - 2];          //直接匹配零个
                    if (matches(s, p, i, j - 1)) {  // a*  a    匹配之后还能继续使用
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {                              //不是*
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }   //默认就是false
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {  //s[i-1]  p[j-1]
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


    //数组版----------------------------------------------------------------------------------------------------
    public boolean isMatch2(String s, String p) {
        char[] pp = p.toCharArray();
        char[] ss = s.toCharArray();
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (pp[j - 1] == '*') {
                    f[i][j] = f[i][j-2];
                    if(matches1(ss,pp,i,j-1)){
                        f[i][j] = f[i][j] || f[i-1][j];
                    }
                } else {
                    if(matches1(ss,pp,i,j)){
                        f[i][j] = f[i-1][j-1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches1(char[] ss, char[] pp, int i, int j) {
        if (i == 0) return false;
        if (pp[j - 1] == '.') {
            return true;
        }
        return ss[i-1] == pp[j-1];
    }
}