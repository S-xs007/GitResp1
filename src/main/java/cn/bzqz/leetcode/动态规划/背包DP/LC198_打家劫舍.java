package cn.bzqz.leetcode.动态规划.背包DP;

import com.dragon.力扣.二叉树.TreeNode;

import java.util.Arrays;

public class LC198_打家劫舍 {

    //1.打家劫舍1
    //房子是一排，不能同时偷两个相邻的房子
    public int rob1(int[] nums) {
        if(nums == null || nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i< nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }

    //2.房子成一环状
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        return Math.max(robb(Arrays.copyOfRange(nums,0,nums.length-1)),robb(Arrays.copyOfRange(nums,1,nums.length)));
    }
    public int robb(int[] nums){    //这个是打家劫舍1的空间优化版
        int pre1 = 0;
        int pre2 = 0;
        for(int num:nums){
            int tem = pre1;
            pre1 = Math.max(num+pre2,pre1);
            pre2 = tem;
        }
        return pre1;
    }


    //3.房子变成了二叉树
    // 树的后序遍历
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        // 分类讨论的标准是：当前结点偷或者不偷
        // 由于需要后序遍历，所以先计算左右子结点，然后计算当前结点的状态值
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int[] dp = new int[2];

        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);  //dp[0] 表示不透
        dp[1] = node.val + left[0] + right[0];                              //dp[1] 表示偷
        return dp;
    }

}
