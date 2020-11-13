package com.dragon.力扣.二叉树;

public class E二叉搜索树的第k大节点 {
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root) {
        if(root==null)return;
        dfs(root.right);
        if(k==0)return;
        if(--k==0)res= root.val;
        dfs(root.left);
    }
}
