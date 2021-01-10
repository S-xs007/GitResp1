package cn.bzqz.leetcode.二叉树;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC二叉树序列化和反序列化 {

}
class CCC {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)return "[]";
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node!=null){
                sb.append(node.val+",");
                queue.offer(node.left);
                queue.offer(node.right);
            }else{
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]"))return null;
        String[] node = data.substring(1,data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(node[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 0;
        while(!queue.isEmpty()){
            TreeNode tem = queue.poll();
            if(!node[++index].equals("null")){
                tem.left = new TreeNode(Integer.parseInt(node[index]));
                queue.offer(tem.left);
            }
            if(!node[++index].equals("null")){
                tem.right = new TreeNode(Integer.parseInt(node[index]));
                queue.offer(tem.right);
            }
        }
        return root;
    }

    //-----------------------------------------------------
    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "Null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }
    public String serialize2(TreeNode root) {
        return rserialize(root, "");
    }


    //----------------------------------------------------
    public TreeNode rdeserialize(List<String> l) {
        if (l.get(0).equals("Null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }

    public TreeNode deserialize2(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }
}