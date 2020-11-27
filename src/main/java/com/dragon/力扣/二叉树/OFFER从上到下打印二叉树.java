package com.dragon.力扣.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OFFER从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if(root==null)return new int[0];
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                TreeNode tem = queue.poll();
                list.add(tem.val);
                if(tem.left!=null)queue.offer(tem.left);
                if(tem.right!=null)queue.offer(tem.right);
                size--;
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);

        return res;
    }
}
