package 蜻蜓笔试;

import java.util.LinkedList;
import java.util.List;

public class QT顺时针打印数组 {
    public static List<Integer> print(int[][] nums){
        int[][] f = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};//四个方向
        int m = nums.length;
        int n = nums[0].length;
        if(m == 0 || n==0)return new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        List<Integer> res = new LinkedList<>();
        res.add(nums[0][0]);
        int sum = m*n;
        int mm = 0;
        int nn = 0;
        int ff = 0;
        int count = 0;
        while(count<sum-1){
            int mTem = mm+f[ff][0];
            int nTem = nn+f[ff][1]; //先走一下看看是否越界
            if(check(m,n,mTem,nTem) && !visited[mTem][nTem]){   //如果没有越界且没有访问过，直接添加到结果集
                res.add(nums[mTem][nTem]);
                mm = mTem;
                nn = nTem;
                visited[mm][nn] = true; //标记为访问过了
                count++;
            }else{
                ff = (ff+1)%4;      //如果越界了或者访问过了
            }
        }
        return res;
    }
    //判断是否越界
    private static boolean check(int m, int n, int mTem, int nTem) {
        if(mTem<0 || mTem>=m || nTem<0 || nTem>=n){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = print(nums);
        System.out.println(list.toString());
    }
}
