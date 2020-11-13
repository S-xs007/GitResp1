package com.dragon.力扣.二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Z二叉树最近公共祖先 {
    //后序遍历
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

}


class Solution {
    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();       //存储父节点
    Set<Integer> visited = new HashSet<Integer>();  //存储已经访问过的节点

    public void dfs(TreeNode root) {
        if(root.left!=null){
            parent.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right!=null){
            parent.put(root.right.val,root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while(p!=null){
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while(q!=null){
            if(visited.contains(q.val)){
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }



}


