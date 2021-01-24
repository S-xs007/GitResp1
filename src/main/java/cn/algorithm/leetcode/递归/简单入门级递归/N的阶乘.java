package cn.algorithm.leetcode.递归.简单入门级递归;

public class N的阶乘 {
    /**
     * 计算n 的阶乘
     * @param n
     * @return
     */
    public int f(int n){
        if(n == 1)return n;
        return n*f(n-1);
    }

    /**
     * 斐波那契数列
     * @param n
     * @return 1、1、2、3、5、8、13、21、34
     */
    public int f1(int n){
        if(n == 2 || n == 1){
            return 1;
        }
        return f(n-1) + f(n-2);
    }


    Node reverseList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

class Node{
    int date;
    Node next;
}
