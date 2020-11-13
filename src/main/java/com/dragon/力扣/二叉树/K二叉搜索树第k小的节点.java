package com.dragon.力扣.二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class K二叉搜索树第k小的节点 {
    //寻找二叉搜索树第k小的节点值
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if(root==null)return list;
        Stack<TreeNode>  stack = new Stack<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

}
