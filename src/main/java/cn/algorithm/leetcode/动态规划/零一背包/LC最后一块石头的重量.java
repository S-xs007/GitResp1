package cn.algorithm.leetcode.动态规划.零一背包;

/**
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。
 *
 * 1.本题就是特殊的01背包问题
 * 背包的总容量就是石头总容量的一般
 * 要放的物体就是石头，质量和价值一样
 */
public class LC最后一块石头的重量 {
    public int lastStoneWeightII(int[] stones) {
        //背包最多放石头总数的一半
        //以为石头必须分成两半
        int n = stones.length;
        int sum = 0;
        for(int s : stones){
            sum+=s;
        }
        int[][] dp = new int[n+1][sum/2+1];
        for(int i = 1;i<=stones.length;i++){
            int curStone = stones[i-1];//得到当前物品的价值，同时也是重量
            for(int j = 1;j<=sum/2;j++){
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if (j >= curStone) {//如果能装下，就看看装还是不装
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - curStone] + curStone);
                }
            }
        }
        int res = sum - 2 * dp[n][sum / 2];
        return res;
    }
}
