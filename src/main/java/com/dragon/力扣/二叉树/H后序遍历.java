package com.dragon.力扣.二叉树;

import java.util.*;

public class H后序遍历 {
    //后续遍历
    /**（左右中）
     * 左节点一次入栈
     * 取出一个节点，如果他没有右节点或者右节点已经打印，该节点就打印
     * 如果有右节点或者右节点没有打印，那就进入右节点
     *
     * 重复以上
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode flag = null;
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right==null||root.right==flag){
                list.add(root.val);
                flag = root;
                root = null;
            }else{
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }




}

/**
 * 递归版本
 */
class solution1{
    List<Integer> list = new ArrayList<>();
    //二叉树后续遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null)return new ArrayList<>();
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }
}