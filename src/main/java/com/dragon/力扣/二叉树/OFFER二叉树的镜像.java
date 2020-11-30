package com.dragon.力扣.二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class OFFER二叉树的镜像 {
    //基本的层序遍历
    public TreeNode mirrorTree1(TreeNode root) {
        if(root == null)return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                TreeNode tem = queue.poll();
                if(tem.left!=null)queue.offer(tem.left);
                if(tem.right!=null)queue.offer(tem.right);
                TreeNode tem1 = tem.left;   //交换左右节点
                tem.left = tem.right;
                tem.right = tem1;
                size--;
            }
        }
        return root;
    }
    //辅助栈
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }

    public TreeNode mirrorTree2(TreeNode root) {
        if(root==null)return null;
        TreeNode left = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(left);
        return root;
    }

}
