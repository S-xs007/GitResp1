package com.dragon.力扣.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q前序遍历 {
    List<Integer> result = new ArrayList<>();
    //递归版本
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)return new ArrayList<>();
        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
    }


    //非递归版本
    /**
     * 提前加入头节点
     * 循环里面弹出一个，打印，有右压右，有左压左
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if(root==null) return result;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null)stack.push(node.left);

        }
        return result;
    }

    }
