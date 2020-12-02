package com.dragon.力扣.二叉树;

import java.util.*;

public class OFFER二叉树的最近公共祖先 {
    //递归方式
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }


    //非递归
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);//根节点没有父节点，所以为空
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()&&!parent.containsKey(p) || !parent.containsKey(q)){
                TreeNode tem = queue.poll();
                if(tem.left!=null) {
                    parent.put(tem.left,tem);
                    queue.offer(tem.left);
                }
                if(tem.right!=null) {
                    parent.put(tem.right,tem);
                    queue.offer(tem.right);
                }
            }
        Set<TreeNode> ancestors = new HashSet<>();
        //记录下p和他的祖先节点，从p节点开始一直到根节点。
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        //查看p和他的祖先节点是否包含q节点，如果不包含再看是否包含q的父节点……
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
        }

}
