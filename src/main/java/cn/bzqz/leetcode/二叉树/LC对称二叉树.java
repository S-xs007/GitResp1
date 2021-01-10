package cn.bzqz.leetcode.二叉树;

public class LC对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        return check(root.left,root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if(left==null&&right==null){
            return true;
        }
        if((left!=null&&right==null)||(left==null&&right!=null)||left.val!=right.val)return false;
        return check(left.left, right.right)&&check(left.right,right.left);
    }
}
