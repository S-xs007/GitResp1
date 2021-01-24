package cn.algorithm.leetcode.二叉树;

public class OFFER二叉搜索树的最近公共祖先 {
    //利用递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }

    //迭代
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null){
            if(root.val>p.val&&root.val>q.val){         //情况1 都在左边
                root = root.left;
            }else if(root.val<p.val&&root.val<q.val){   //情况2 都在右边
                root = root.right;
            }else {
                return root;                            //情况三在两边
            }
        }
        return root;
    }

    }
