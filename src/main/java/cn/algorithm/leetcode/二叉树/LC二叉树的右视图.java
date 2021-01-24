package cn.algorithm.leetcode.二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
                if(i==size-1){
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
