package cn.algorithm.leetcode.二叉树;

import com.dragon.力扣.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class OFFER二叉树的三序遍历 {
    List<Integer> result = new ArrayList<>();
    //递归版本
    public List<Integer> preorderTraversal(com.dragon.力扣.二叉树.TreeNode root) {
        if(root==null)return new ArrayList<>();
        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
    }


    //前序遍历  中  左   右
    /**
     * 提前加入头节点
     * 循环里面弹出一个，打印，有右压右，有左压左
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new LinkedList<>();        //结果集合
        if(root==null) return result;
        LinkedList<TreeNode> stack = new LinkedList<>();        //栈
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right!=null) stack.push(node.right);        //先呀右  在压左
            if(node.left!=null)stack.push(node.left);

        }
        return result;
    }
    //中序遍历    左  中  右
    public List<Integer> midTraversal1(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root==null)return result;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    //后续遍历  左   右   中
    /**（左右中）
     * 左节点一次入栈
     * ，如果他没有右节点或者右节点已经打印，该节点就打印
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
            while(root!=null){  //左节点一次性入栈
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();   //取出一个节点
            if(root.right==null||root.right==flag){ //没有右节点或者右节点已经打印过了（就便是当前节点是中）可以打印
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

    List<Integer> list = new ArrayList<>();
    //二叉树后续遍历
    public List<Integer> postorderTraversal(com.dragon.力扣.二叉树.TreeNode root) {
        if(root==null)return new ArrayList<>();
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    }
