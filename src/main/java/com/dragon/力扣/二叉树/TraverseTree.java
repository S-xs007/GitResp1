package com.dragon.力扣.二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class TraverseTree {

    //中序遍历（左中右）
    public List<Integer> midTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();

        while(root!=null||!stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

}
