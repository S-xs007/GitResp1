package cn.algorithm.leetcode.二叉树;

import java.util.LinkedList;
import java.util.List;

public class OFFER二叉树中和为某一值的路径 {
    //利用先序遍历
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    /**
     * 1.函数的含义，得到所有的路径
     * 2.什么时候退出：节点为空/找到了路径
     * 3.剪枝
     * @param root
     * @param tar
     */
    void recur(TreeNode root, int tar) {
        if(root == null) return;    //节点为空就结束
        path.add(root.val);     //添加到路径中
        tar -= root.val;        //
        if(tar == 0 && root.left == null && root.right == null) res.add(new LinkedList(path));//find it
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }
}
