package cn.algorithm.leetcode.动态规划;

public class M中国象棋 {

    /**
     * 中国象棋从00点开始走k步到x，y有几种可能
     * @param x
     * @param y
     * @param k
     * @return
     */
    public static int f(int x,int y,int k){
        if(k==0){       //没有步数要走了
            return x==0&&y==0?1:0;
        }
        //判断边界
        if(x<0||x>9||y<0||y>8){
            return 0;
        }
        return f(x+2,y-1,k-1)
                +f(x+2,y+1,k-1)
                +f(x+1,y+2,k-1)
                +f(x-1,y+2,k-1)
                +f(x-2,y+1,k-1)
                +f(x-2,y-1,k-1)
                +f(x-1,y-2,k-1)
                +f(x+1,y-2,k-1);
    }


    public static void main(String[] args) {
        System.out.println(f(2,3,3));
        System.out.println(f1(2,3,3));
    }

    /**
     * 动态规划实现
     * @param x
     * @param y
     * @param k
     * @return
     */
    public static int f1(int x,int y,int k){
        int[][][] dp = new int[10][9][k+1];
        dp[0][0][0] = 1;
        for(int level=0;level<=k;level++){  //层数
            for(int i = 0;i<10;i++){        //x的可能
                for(int j = 0;j<9;j++){     //y的可能
                    dp[i][j][level] = getValue(dp,i+2,j-1,level-1)
                            + getValue(dp,i+2,j+1,level-1)
                            + getValue(dp,i+1,j+2,level-1)
                            + getValue(dp,i-1,j+2,level-1)
                            + getValue(dp,i-2,j+1,level-1)
                            + getValue(dp,i-2,j-1,level-1)
                            + getValue(dp,i-1,j-2,level-1)
                            + getValue(dp,i+1,j-2,level-1);
                }
            }
        }
        return dp[x][y][k];
    }
    public static int getValue(int[][][]dp,int x,int y,int k){
        //判断边界
        if(x<0||x>9||y<0||y>8){
            return 0;
        }
        return dp[x][y][k];
    }
}
