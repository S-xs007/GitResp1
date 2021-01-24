package cn.algorithm.leetcode.动态规划;

public class OFFER正则表达式匹配 {

    //递归版本
    /*public boolean isMatch1(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();//匹配串空了，要看一个字符串还有灭有
        boolean match = !s.isEmpty() && ((s.charAt(0) == p.charAt(0)) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*')
            return isMatch(s, p.substring(2)) || (match && isMatch(s.substring(1), p));
        return match && isMatch(s.substring(1), p.substring(1));
    }*/
    //数组版----------------------------------------------------------------------------------------------------
    public boolean isMatch2(String s, String p) {
        char[] pp = p.toCharArray();
        char[] ss = s.toCharArray();
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];  //判断是否已经访问过了
        f[0][0] = true;
        for (int i = 0; i <= m; i++) {//字符串
            for (int j = 1; j < n + 1; j++) {//正则表达式（从1开始是因为*要看前一个）
                //1.情况1 是*
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