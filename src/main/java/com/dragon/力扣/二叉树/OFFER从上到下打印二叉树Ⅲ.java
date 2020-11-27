package com.dragon.力扣.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OFFER从上到下打印二叉树Ⅲ {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null)return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag =true; //从左到右
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> temList = new LinkedList<>();
            while(size>0){
                TreeNode tem = queue.poll();
                if(flag){
                    temList.addLast(tem.val);
                }else {
                    temList.addFirst(tem.val);
                }
                if(tem.left!=null)queue.offer(tem.left);
                if(tem.right!=null)queue.offer(tem.right);
                size--;
            }
            lists.add(temList);
            flag = !flag;
        }
        return lists;
    }
}
