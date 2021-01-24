package cn.algorithm.leetcode.二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC填充每一个节点的右侧节点指针 {
    //方法一
    public Node connect(Node root) {
        if(root==null)return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Node> list = new LinkedList<>();
            while(size>0){
                Node node = queue.poll();
                list.add(node);
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
                size--;
            }
            int s = list.size();
            for(int i = 0;i<s;i++){
                list.get(i).next = i+1<s?list.get(i+1):null;
            }
        }
        return root;
    }
    //方法二
    public Node connect1(Node root) {
        if (root == null) {
            return root;
        }

        // 从根节点开始
        Node leftmost = root;

        while (leftmost.left != null) {

            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;

            while (head != null) {

                // CONNECTION 1
                head.left.next = head.right;

                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // 指针向后移动
                head = head.next;
            }

            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }

        return root;
    }


    //不是完全二叉树
    Node last = null, nextStart = null;
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    public void handle(Node p) {
        if (last != null) {
            last.next = p;
        }
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
    }

}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};