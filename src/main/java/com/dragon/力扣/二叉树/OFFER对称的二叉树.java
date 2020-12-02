package com.dragon.力扣.二叉树;

public class OFFER对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true; //左右节点都为空   对
        if(L == null || R == null || L.val != R.val) return false;  //有一个不为空   或者值不等   不对
        return recur(L.left, R.right) && recur(L.right, R.left);    //继续判断左节点的左右节点和右节点的左右节点
    }

}
