package cn.algorithm.leetcode.二叉树;

class SortTree {

    public static Info bigNode(TreeNode root){
      if(root==null) return new Info(false,0);
      Info left = bigNode(root.left);
      Info right = bigNode(root.right);
      int value = Math.max(left.value,right.value);
      boolean isSort = left.isSort == true && right.isSort == true && root.val > root.left.val && root.val < root.right.val ? true : false;
      return new Info(isSort,value);
    }
}



class Info{
    public boolean isSort;
    public int value;

    public Info(boolean isSort, int value) {
        this.isSort = isSort;
        this.value = value;
    }
}