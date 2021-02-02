package cn.algorithm.leetcode.二叉树.二叉树的遍历.衍生题目;

import cn.algorithm.leetcode.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//
//例如输入：
//
//  4
// /  \
// 2   7
/// \  / \
//1  3 6  9
//镜像输出：
//
//  4
// /  \
// 7   2
/// \ / \
//9  6 3 1
//
//
public class OFFER二叉树的镜像 {
    //基本的层序遍历
    public TreeNode mirrorTree1(TreeNode root) {
        if(root == null)return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                TreeNode tem = queue.poll();
                if(tem.left!=null)queue.offer(tem.left);
                if(tem.right!=null)queue.offer(tem.right);
                //
                TreeNode tem1 = tem.left;   //交换左右节点
                tem.left = tem.right;
                tem.right = tem1;
                //
                size--;
            }
        }
        return root;
    }
    //辅助栈
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }

}
