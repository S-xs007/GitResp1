package com.dragon.力扣.二叉树;

/**
 * 求二叉树最远的两个节点的距离
 */
public class BigPath {
    public static Info1 process(TreeNode root){
        if(root==null)return new Info1(0,0);
        Info1 left = process(root.left);
        Info1 right = process(root.right);
        int height = Math.max(left.height,right.height)+1;
        int maxDistance = Math.max(Math.max(left.maxDistance,right.maxDistance),left.height+right.height+1);
        return new Info1(maxDistance,height);
    }
}
class Info1{
    public int maxDistance;
    public int height;

    public Info1(int maxDistance, int height) {
        this.maxDistance = maxDistance;
        this.height = height;
    }
}