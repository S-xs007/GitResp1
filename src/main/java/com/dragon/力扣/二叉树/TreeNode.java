package com.dragon.力扣.二叉树;

public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode parent;
     TreeNode() {}
     public TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}