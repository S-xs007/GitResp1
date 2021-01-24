package cn.algorithm.leetcode.动态规划;

import com.dragon.力扣.二叉树.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC三种打家劫舍 {
    //打家劫舍1的初级版
    public int rob11(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 子问题：
        // f(k) = 偷 [0..k) 房间中的最大金额

        // f(0) = 0
        // f(1) = nums[0]
        // f(k) = max{ rob(k-1), nums[k-1] + rob(k-2) }

        int N = nums.length;
        int[] dp = new int[N+1];
        dp[0] = 0;      //没有房子当然是 0 了
        dp[1] = nums[0];
        for (int k = 2; k <= N; k++) {
            dp[k] = Math.max(dp[k-1], nums[k-1] + dp[k-2]);
        }
        return dp[N];
    }
    //空间优化版本
    public int rob111(int[] nums) {
        //   n-2      n-1
        int pre = 0, cur = 0;   //以为是从1个房间开始，所以初始化都是0
        for (int num : nums) {
            int tmp = cur;
            cur = Math.max(pre + num, cur);   // dp[n+1] = Math.max(dp[n-1] + num,dp[n])
            pre = tmp;
        }
        return cur;
    }


    //打家劫舍2     (房子连城一个环)
    public int rob1(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),    //不要最后一个
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));                   //不要第一个
    }
    private int myRob(int[] nums) {
        //   n-2      n-1
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);   // dp[n+1] = Math.max(dp[n-1] + num,dp[n])
            pre = tmp;
        }
        return cur;
    }


    //打家劫舍3     房子变成了二叉树
    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

    public int rob3(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));  //root节点选择或者不选择的最大值
    }
    //后续遍历
    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);//左
        dfs(node.right);//右
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));//选择 node  f(node) = g(node.left) + g(node.right)
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }





}
