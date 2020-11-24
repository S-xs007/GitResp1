package com.dragon.力扣.二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zxS
 * @Date: 15:08 2020/11/24
 * @Description：
 */
public class OFFER序列化二叉树 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else res.append("null,");
        }
        res.deleteCharAt(res.length() - 1); //删除最后一个逗号
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] str = data.substring(1,data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(str[0])); //根节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!str[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(str[i]));
                queue.add(node.left);
            }
            i++;
            if(!str[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(str[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

}
