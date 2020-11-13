package com.dragon.力扣.二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class TreeMaxWidth {
    //先序序列化--递归
    public static Queue<Integer> preToQueue(TreeNode root)
    {
        Queue<Integer> queue = new LinkedList<>();
        pre(root,queue);
        return queue;

    }
    public static void pre(TreeNode root,Queue<Integer> queue){
        if(root==null){
            queue.offer(null);
        }else{
            queue.offer(root.val);  //这句话的位置改了就是中序和后序
            pre(root.left,queue);
            pre(root.right,queue);
        }

    }
    //先序反序列化--递归
    public static TreeNode buildByPre(Queue<Integer> queue){
        Integer value = queue.poll();
        if(value==null)return null;
        TreeNode root = new TreeNode(value);    //这句话的位置决定了先中后
        buildByPre(queue);
        buildByPre(queue);
        return root;
    }



    public static int maxWidth02(TreeNode root){
        if(root==null)return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curEnd = root; //当前层最右节点
        TreeNode nextEnd = null;//下一层最右节点
        int max = 0;
        int curLevelNodes = 0;//当前层节点数
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if(curNode.left!=null){
                queue.offer(curNode.left);
                nextEnd = curEnd.left;
            }
            if(curNode.right!=null){
                queue.offer(curNode.right);
                nextEnd = curNode.right;
            }
            curLevelNodes++;
            if(curNode==curEnd){
                max = Math.max(curLevelNodes,max);
                curLevelNodes=0;
                curEnd = nextEnd;
            }
        }
        return max;
    }


    //二叉树的层序遍历
    public static List<List<Integer>> levelTree(TreeNode root){
        List<List<Integer>> finalList = new ArrayList<>();
        if(root==null) return finalList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size>0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
                size--;
            }
            finalList.add(list);
        }
        return finalList;

    }
}
