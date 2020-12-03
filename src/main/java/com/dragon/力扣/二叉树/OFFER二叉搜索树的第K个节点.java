package com.dragon.力扣.二叉树;

import java.util.Stack;

public class OFFER二叉搜索树的第K个节点 {
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            if(--k==0){
                return root.val;
            }
            root = root.left;
        }
        return -1;
    }
}
