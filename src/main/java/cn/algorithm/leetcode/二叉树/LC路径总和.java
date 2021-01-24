package cn.algorithm.leetcode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class LC路径总和 {
    //什么时候开始判断？ 到达了根节点  （root.left == null && root.right == null）
//社么时候退出？    节点为空
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    //层序遍历
    public boolean hasPathSum1(TreeNode root, int sum) {
        if(root == null)return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueVal = new LinkedList<>();
        queueVal.offer(root.val);
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int tem = queueVal.poll();
           if(node.left==null && node.right==null){
               if(tem == sum)return true;
               else continue;
           }
            if (node.left != null) {
                queue.offer(node.left);
                queueVal.offer(node.left.val + tem);
            }
            if (node.right != null) {
                queue.offer(node.right);
                queueVal.offer(node.right.val + tem);
            }

        }
        return false;
    }
}
