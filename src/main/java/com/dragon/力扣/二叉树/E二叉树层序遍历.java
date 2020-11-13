package com.dragon.力扣.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E二叉树层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size>0){
                TreeNode node = queue.poll();
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
                list.add(node.val);
                size--;
            }
            result.add(list);
        }
        return result;
    }
}
