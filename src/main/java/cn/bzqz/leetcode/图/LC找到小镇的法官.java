package cn.bzqz.leetcode.图;

public class LC找到小镇的法官 {
    public int findJudge(int N, int[][] trust) {
        int[] in = new int[N+1];
        int[] out = new int[N+1];
        for(int[] tem:trust){
            int from = tem[0];
            out[from]++;
            int to = tem[1];
            in[to]++;
        }
        for(int i = 1;i<=N;i++){
            if(in[i] == N-1 && out[i] == 0){ //所有人都信任，并且不信任任何人
                return i;
            }
        }
        return -1;
    }
}
