package cn.bzqz.leetcode.二叉树;

import java.util.*;

public class LC二叉树的最近公共祖先 {
    //递归后续遍历
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;
        if(root == p || root == q)return root;
        TreeNode left =  lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null)return right;
        if(right==null)return left;
        return root;//都不为空说明左右一边一个
    }

    //利用map保存父节点
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;
        Map<Integer,TreeNode> parent = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tem = queue.poll();
            if(tem.left!=null){
                parent.put(tem.left.val,tem);
                queue.offer(tem.left);
            }
            if(tem.right!=null){
                parent.put(tem.right.val,tem);
                queue.offer(tem.right);
            }
        }
        while(p!=null){
            set.add(p.val);
            p = parent.get(p.val);
        }
        while(q!=null){
            if(set.contains(q.val))return q;
            q = parent.get(q.val);
        }
        return null;
    }
}
