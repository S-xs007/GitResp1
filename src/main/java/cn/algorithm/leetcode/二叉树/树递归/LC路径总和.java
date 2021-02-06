package cn.algorithm.leetcode.二叉树.树递归;

import cn.algorithm.leetcode.二叉树.TreeNode;

public class LC路径总和 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if(root.left==null && root.right==null){
            return root.val == targetSum;
        }
        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }
}
