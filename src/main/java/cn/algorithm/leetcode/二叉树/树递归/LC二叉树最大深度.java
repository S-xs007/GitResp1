package cn.algorithm.leetcode.二叉树.树递归;

import cn.algorithm.leetcode.二叉树.TreeNode;

import javax.security.auth.login.CredentialNotFoundException;

public class LC二叉树最大深度 {
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
