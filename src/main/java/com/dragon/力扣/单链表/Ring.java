package com.dragon.力扣.单链表;

import java.util.Stack;

public class Ring {

    /**
     * 判断链表是不是环形的
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        //最少三个节点成环
        if(head==null||head.next==null||head.next.next==null){
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while(fast!=slow){
            //如果快节点走到头了还没有，直接返回null，说明不成欢
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }


    /**
     * 链表的第倒数k个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        int n = 0;
        while(fast.next!=null){
            if(n==k-1){
                slow =slow.next;
                n--;
            }
            fast = fast.next;
            n++;
        }
        return slow;
    }


    /**
     * 从后往前打印head
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode head1 = head;
        while(head1!=null){
            stack.push(head1);
            head1 = head1.next;
        }
        int size = stack.size();
        int[] re = new int[size];
        for(int i = 0;i<size;i++){
            re[i] = stack.pop().val;
        }
        return re;
    }
}
