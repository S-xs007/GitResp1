package cn.algorithm.leetcode.链表;

import java.util.HashMap;

/**
 * 链表的复制
 */
public class F复制带有随机指针的链表 {
    //单链表定义
    public static class Node {
        public int val;
        public Node next;
        public Node random;
        public Node(int data) {
            this.val = data;
        }
    }

    /**
     *     利用map的复制（笔试）----通过leetcode（复杂链表的复制）
     */
    public static Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        //1.cur  对应的新节点
        while(cur!=null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        //2.设置next和random
        while(cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur =cur.next;
        }
        return map.get(head);

    }


    /**
     *     原地修改不适用额外空间 ----通过leetcode（复杂链表的复制）
     */
    public static Node copyRandomList01(Node head){
        if(head==null)return null;
        //1.复制节点
        Node cur = head;
        Node next = null;
        //1-1'-2-2'--
        while(cur!=null){
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        //2.设置random指针
        cur = head;
        while(cur!=null){   //设置random
            next = cur.next.next;   //保存下一个1 2 3
            /*curCopy = cur.next;
            curCopy.random = cur.random != null ? cur.random.next : null;*/
            cur.next.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }

        //3.断开next(每次之断开第一个新旧节点)-----（重点理解）
        Node xin1 = head.next;//新链表的头部
        cur = head;
        Node curCopy=null;
        while (cur != null) {
            next = cur.next.next;   //记录下一个老节点
            curCopy = cur.next;     //记录新节点
            cur.next = next;        //新节点next重新指向
            curCopy.next = next != null ? next.next : null;

            cur = next;
        }
        return xin1;
    }


    public Node copyRandomList1(Node head) {
        if(head==null)return null;
        //1.
        Node cur = head;
        Node next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }

        //2.
        cur = head;
        while (cur!=null){
            next = cur.next.next;
            cur.next.random = cur.random==null?null:cur.random.next;
            cur = next;
        }


        Node xin = head.next;
        cur = head;
        Node xinNode = null;
        while(cur!=null){
            next = cur.next.next;   //记录下一个旧节点

            xinNode = cur.next;     //记录下一个新节点
            cur.next = next;
            xinNode.next = next!=null?next.next:null;

            cur = next;
        }
        return xin;
    }
    }
