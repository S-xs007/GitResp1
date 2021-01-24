package cn.algorithm.leetcode.二叉树;

import java.util.Stack;

public class E二叉搜索树的第k大节点 {
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root) {
        if(root==null)return;
        dfs(root.right);
        if(k==0)return;
        if(--k==0)res= root.val;
        dfs(root.left);
    }

    //方法2.利用反向中序遍历
    public int kthLargest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty()|| root!=null){
            while(root!=null){
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            if(--k == 0)return root.val;
            root = root.left;
        }
        return -1;
    }
}
