package com.dragon.力扣.二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

public class Z中序遍历 {

    public List<Integer> midTraversal1(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if(root==null)return result;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.addLast(root.val);
            root = root.right;
        }
        return result;
    }



    }
