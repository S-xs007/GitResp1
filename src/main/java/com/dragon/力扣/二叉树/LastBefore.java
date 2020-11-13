package com.dragon.力扣.二叉树;

/**
 * 求中序遍历后继节点
 */
public class LastBefore {

    public static TreeNode afterNode(TreeNode node){
        if(node==null)return null;
        if(node.right!=null){
            return leftMost(node);
        }else{  //没有有树
            TreeNode parent = node.parent;
            while(parent!=null&&node==parent.right){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static TreeNode leftMost(TreeNode node){
        if(node==null)return null;
        while(node.left !=null){
            node = node.left;
        }
        return node;
    }
    public static TreeNode rightMost(TreeNode node){
        if(node==null)return null;
        while(node.right!=null){
            node = node.right;
        }
        return node;
    }
}
