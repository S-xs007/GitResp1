package cn.algorithm.leetcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zxS
 * @Date: 15:02 2020/11/24
 * @Description：正常的bfs，但是每一层记过需要判断顺序
 */
public class OFFER二叉树的锯齿型层次遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>(new ArrayList<>());

        List<List<Integer>> result = new ArrayList<>(); //结果
        Queue<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(root);
        LinkedList<Integer> level = new LinkedList<>(); //保存每一层的结果
        boolean flag = true;   //
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            while (size>0){
                TreeNode tem = linkedList.poll();
                if (flag){
                    level.addLast(tem.val);
                }
                else{
                    level.addFirst(tem.val);
                }
                if (tem.left != null) {
                    linkedList.offer(tem.left);
                }
                if (tem.right != null) {
                    linkedList.offer(tem.right);
                }
                size--;
            }
                result.add(level);
                level = new LinkedList<>();
                flag = !flag;
        }
        return result;
    }
}
