package cn.bzqz.leetcode.字符串;
//O(n)
public class Code01_KMP {
    //KMP就是快速判断  给定m是不是在 s字符串中
    public static int getIndex(String s,String m){
        if(s == null || m == null || s.length() == 0 || m.length() ==0){
            return -1;
        }
        char[] str = s.toCharArray();
        char[] match = m.toCharArray();
        int x = 0;      //字符串数组索引
        int y = 0;      //match数组的索引
        int[] next = getNextArr(match); // 第一个位置是-1  往后如果没有匹配就等于0
        while(x < s.length() && y < m.length()){
            if(str[x] == match[y]){
                x++;
                y++;
            } else if(next[y] == -1){   //只有0位置的next才是-1  所以也可以写  y==0
                x++;
            } else{
                y = next[y];
            }
        }
        return y == match.length ? y-x : -1;
    }

    private static int[] getNextArr(char[] match) {
        if(match.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[match.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        //cn代表位置，和i-1位置相比的字符
        int cn = 0;
        while (i < next.length){
            if(match[i-1] == match[cn]){    //跳出来的时候
                next[i++] = ++cn;
            } else if(cn > 0){      //不相等就往前跳
                cn = next[cn];
            } else {                //跳到0位置了还不行 就是0
                next[i++] = 0;
            }
        }
        return next;
    }
}
