package com.dragon.力扣.链表;


import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * @Author: zxS
 * @Date: 13:18 2020/11/20
 * @Description：根据前序和中序重建二叉树
 */
public class OFFER重建二叉树 {

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[0]);
            int length = preorder.length;
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            int inorderIndex = 0;
            for (int i = 1; i < length; i++) {  //遍历先序
                int preorderVal = preorder[i];
                TreeNode node = stack.peek();
                if (node.val != inorder[inorderIndex]) {    //只要中序遍历的第一个节点的值 ！= 当前先序遍历的值（就是说明时左节点）
                    node.left = new TreeNode(preorderVal);
                    stack.push(node.left);
                } else {    //是右节点，但不知道时那个的右节点
                    while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                        node = stack.pop();
                        inorderIndex++;
                    }
                    node.right = new TreeNode(preorderVal);
                    stack.push(node.right);
                }
            }


            return root;
        }



    /**
     * 思路：
     * 1.判空
     * 2.首先先序便利的第一个节点作为根节点放到栈中
     * 3.从下一个开始遍历先序遍历，如果当前先序遍历的值  ！=  中序遍历的指针处的值  就说明时上一个节点的左节点
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
            if(preorder.length==0||preorder==null)return null;

            Stack<TreeNode> stack = new Stack<>();
            TreeNode root = new TreeNode(preorder[0]);
            stack.push(root);
            int inorderIndex = 0;
            for(int i = 1;i<preorder.length;i++){
                TreeNode node = stack.peek();
                if(node.val != inorder[inorderIndex]){      //左节点
                    node.left = new TreeNode(preorder[i]);
                    stack.push(node.left);
                }else {                                     //右节点，需要往回找，栈中第一个和中序指针值 不相等 的节点
                    while(!stack.isEmpty()&&stack.peek().val == inorder[inorderIndex]){
                        node = stack.pop();
                        inorderIndex++;
                    }
                    node.right = new TreeNode(preorder[i]);
                    stack.push(node.right);         //无论是左节点还是右节点都需要加入栈中
                }
            }
            return root;
    }

}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }