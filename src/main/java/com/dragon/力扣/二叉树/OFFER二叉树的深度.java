package com.dragon.力扣.二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class OFFER二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            while (size>0){
                TreeNode node = queue.poll();
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
                size--;
            }
        }
        return depth;
    }

    //深度优先搜索
    public int maxDepth1(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
