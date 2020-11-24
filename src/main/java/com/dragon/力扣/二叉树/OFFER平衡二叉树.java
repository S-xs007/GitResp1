package com.dragon.力扣.二叉树;
/**
 * @Author: zxS
 * @Date: 14:16 2020/11/24
 * @Description：一个根节点为Node的子树要是一颗平衡树必须满足以下三个条件：
 *
 * Node的左子树是平衡树
 * Node的右子树是平衡树
 * Node的左子树和右子树的深度差值小于等于1
 *
 *
 */
public class OFFER平衡二叉树 {
    //下面的方法的简写版本
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return Math.abs(depth(root.left)-depth(root.right))<=1 && isBalanced(root.left)&&isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }



}
class AAA{
    //方法作用：以node为节点的树是否平衡
    public boolean isBalanced(TreeNode node) {
        if(node == null) return true;//如果节点为空返回true
        if(!isBalanced(node.left)){//如果左子树不平衡返回false
            return false;
        }
        if(!isBalanced(node.right)){//如果右子树不平衡返回false
            return false;
        }
        //左右都为平衡
        int l = getDepth(node.left);
        int r = getDepth(node.right);
        if(Math.abs(r - l) > 1){//如果左右子树的深度相差超过一返回false
            return false;
        }
        return true;
    }
    //获取以node为根的子树深度
    public int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = getDepth(node.left) + 1;
        int r = getDepth(node.right) + 1;
        return r > l ? r : l;
    }
}
